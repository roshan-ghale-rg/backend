package com.uhcl.amazonsellers.schedular;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.uhcl.amazonsellers.Utilities.HelperClass;
import com.uhcl.amazonsellers.Utilities.StringUtilities;
import com.uhcl.amazonsellers.domain.AlgorithmData;
import com.uhcl.amazonsellers.domain.AmazonData;
import com.uhcl.amazonsellers.domain.ScrappingData;
import com.uhcl.amazonsellers.repository.ProductRepository;
import com.uhcl.amazonsellers.serviceImpl.AsyncService;
import com.uhcl.amazonsellers.serviceImpl.BulkImporterService;
import com.uhcl.amazonsellers.serviceImpl.CompetitiveSeller;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Configuration
@EnableScheduling
public class SchedulerConfiguration {
    private static Logger log = LoggerFactory.getLogger(SchedulerConfiguration.class);

    @Autowired
    private AsyncService service;
    @Autowired
    private BulkImporterService bulkImporterService;

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CompetitiveSeller competitiveSeller;

    @Scheduled(cron = "0 0 */8 ? * *") // Every 8 hours
    public void scheduleTaskUsingCronExpression() throws InterruptedException, ExecutionException {
        long now = System.currentTimeMillis() / 1000;
        log.info(
                "schedule tasks using cron jobs - " + now);
        //TODO Multihtreading asynchronous call.
        List<String> list = productRepository.findDistinctASIN();
        String url = HelperClass.dataCollectorAPI;
        if(!list.isEmpty()) {
            Map jsonObject = new HashMap();
            jsonObject.put("asin", StringUtilities.convertListToString(list));
            //jsonObject.put("asin","B07DHS61KR");
            jsonObject.put("condition", "new");
            jsonObject.put("shipping", "all");
            jsonObject.put("country","uk");//TODO change from the database.
            CompletableFuture<JSONObject> results = service.postData(url, jsonObject);
            bulkImporterService.bulkWithEntityManager(doObjectMapping(results.get()));
        }
    }

    private static List<ScrappingData> doObjectMapping(JSONObject results){
        List<ScrappingData> list = new ArrayList<>();
        for(String key : results.keySet()){
            String jsonStringArray = results.getJSONArray(key).toString();
            Gson converter = new Gson();
            Type type = new TypeToken<List<ScrappingData>>(){}.getType();
            ArrayList<ScrappingData> javaArrayListFromGSON =  converter.fromJson(jsonStringArray, type );
            list.addAll(javaArrayListFromGSON);
        }
        return list;
    }

    @Scheduled(cron = "0 0 12 * * ?") //Every day at noon - 12pm
    public void scheduleTaskForBestSellers() throws InterruptedException, ExecutionException {
        long now = System.currentTimeMillis() / 1000;
        log.info(
                "schedule tasks using cron jobs - " + now);
        List<String> usList = competitiveSeller.getDistinctASINAndAdditionalInfo("US");
        List<String> ukList = competitiveSeller.getDistinctASINAndAdditionalInfo("UK");
        String url = HelperClass.bestSellersAPI;
        List <Map>  newList = new ArrayList<>();
        if(!usList.isEmpty()) {
            Map jsonObject = new HashMap();
            jsonObject.put("url", StringUtilities.convertListToString(usList));
            jsonObject.put("country","us");
            newList.add(jsonObject);
        }
        if(!ukList.isEmpty()){
            Map jsonObject = new HashMap();
            jsonObject.put("url", StringUtilities.convertListToString(ukList));
            jsonObject.put("country","uk");
            newList.add(jsonObject);
        }
        CompletableFuture<JSONObject>[] results = new CompletableFuture[newList.size()];
        for(int i= 0; i< newList.size(); i++){
            //TODO For efficiency Queues is needed.
            results[i]= service.postData(url, newList.get(i));
        }
        CompletableFuture.allOf(results).get();
        for(int i =0; i< results.length; i++){
            bulkImporterService.bulkImportWithEntityManager(doObjectGSONMapping(results[i].get()));
        }

    }

   @Scheduled(cron = "0 0 */4 ? * *")
    public void initializeAlgorithm() throws InterruptedException, ExecutionException {
        Map<String,HashMap<String,StringBuffer>> map = competitiveSeller.getTextFromSellers();
        System.out.println("CrawlerIds... "+map.keySet());
        if(map.keySet().size()>0) {
            String url = HelperClass.keywordAPI;
            for (Map.Entry<String, HashMap<String, StringBuffer>> entry : map.entrySet()) {
                String key = entry.getKey();
                HashMap<String,StringBuffer> value = entry.getValue();
                Map jsonObject =new HashMap();
                jsonObject.put("description",value.get("descriptionList").toString());
                jsonObject.put("title",value.get("titleList").toString());
                jsonObject.put("uniqueCrawledId",key);
                CompletableFuture<JSONObject> results = null;
                results= service.postData(url,jsonObject);
                bulkImporterService.bulkImportWithEntityManagerForAlgorithm(doObjectGSONSummaryMapping(results.get()));
                Thread.sleep(1000);
                if(results.get() != null){
                    competitiveSeller.updateAmazonTable(key);
                }

            }

        }

    }

    private static List<AmazonData> doObjectGSONMapping(JSONObject results){
        List<AmazonData> list = new ArrayList<>();
        for(String key : results.keySet()){
            String jsonStringArray = results.getJSONArray(key).toString();
            Gson converter = new Gson();
            Type type = new TypeToken<List<AmazonData>>(){}.getType();
            ArrayList<AmazonData> javaArrayListFromGSON =  converter.fromJson(jsonStringArray, type );
            list.addAll(javaArrayListFromGSON);
        }
        return list;
    }


    private static List<AlgorithmData> doObjectGSONSummaryMapping(JSONObject results){
        List<AlgorithmData> list = new ArrayList<>();
        for(String key : results.keySet()){
            String jsonStringArray = results.getJSONArray(key).toString();
            Gson converter = new Gson();
            Type type = new TypeToken<List<AlgorithmData>>(){}.getType();
            ArrayList<AlgorithmData> javaArrayListFromGSON =  converter.fromJson(jsonStringArray, type );
            list.addAll(javaArrayListFromGSON);
        }
        return list;
    }
}
