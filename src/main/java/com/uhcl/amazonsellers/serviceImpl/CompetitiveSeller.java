package com.uhcl.amazonsellers.serviceImpl;

import com.uhcl.amazonsellers.domain.AlgorithmData;
import com.uhcl.amazonsellers.domain.AmazonData;
import com.uhcl.amazonsellers.domain.ScrappingData;
import com.uhcl.amazonsellers.domain.SellerCashflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.*;

@Service
public class CompetitiveSeller {
    private EntityManagerFactory entityManagerFactory;

    public static  Date getEarlyDate()
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -30);
        Date dateBefore30Days = cal.getTime();

        return dateBefore30Days;
    }


    @Autowired
    public CompetitiveSeller(EntityManagerFactory entityManagerFactory) {
        Assert.notNull(entityManagerFactory, "EntityManagerFactory must not be null");
        this.entityManagerFactory = entityManagerFactory;
    }

    public List<ScrappingData> getCompetitiveSellers(String asinNumber) {
        System.out.println("ASIN IS "+ asinNumber);
        Date date=getEarlyDate();
        System.out.println("Before 7 Days"+date );
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT  data FROM ScrappingData data WHERE data.asin = :asinNO AND data.recordedTime > :date ");
        query.setParameter("asinNO", asinNumber);
        query.setParameter("date", date);
        query.setMaxResults(5);
        List<ScrappingData> sellersList = query.getResultList();
        sellersList.size();
/*
        for(ScrappingData data : sellersList) {
            System.out.println(data.);
        }*/
        entityManager.close();
        return sellersList;
    }

    public List<String> getDistinctASINAndAdditionalInfo(String country) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT distinct(data.queryId), data.bestSellerUrl,data.recordedTime FROM ScrappingData as data WHERE data.queryId is not null and data.queryId <> '' and data.country =:cou order by data.recordedTime DESC ");
        query.setParameter("cou", country);
        query.setMaxResults(10);
        List<Object[]> sellersList = query.getResultList();
        entityManager.close();
        return mergeToUniqueUrl(sellersList);
    }

    public Map<String,HashMap<String,StringBuffer>> getTextFromSellers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT data FROM AmazonData  as data\n" +
                "WHERE data.isProcessed IS FALSE AND data.sellerId is not null and data.uniqueCrawledId IN (SELECT DISTINCT(uniqueCrawledId) FROM AmazonData)\n" +
                "ORDER BY data.createdDate,data.uniqueCrawledId,data.rank ");
        List<AmazonData> sellersList = query.getResultList();
        entityManager.close();
        return makeAMap(sellersList);
    }
    private static Map<String,HashMap<String,StringBuffer>> makeAMap(List<AmazonData> sellersList){
        Map<String,HashMap<String,StringBuffer>> map = new HashMap();
        for (AmazonData data : sellersList){
            String uniqueId= data.getUniqueCrawledId();
            if(!map.containsKey(uniqueId)){
                map.put(uniqueId, new HashMap<>());
                //map.get(uniqueId).put("idList", new Long());
                map.get(uniqueId).put("titleList", new StringBuffer());
                map.get(uniqueId).put("descriptionList", new StringBuffer());

            }
            map.get(uniqueId).get("titleList").append(data.getProductTitle()+" ");
            map.get(uniqueId).get("descriptionList").append(data.getProductTitle()+"");

        }
        return map;

    }

    private static List<String> mergeToUniqueUrl(List<Object[]> dataList){
        List<String> urlList = new ArrayList();
        ArrayList<String> flagList = new ArrayList<>();
        if(!dataList.isEmpty()){
            for(Object[] data : dataList){
                Long queryId = (Long) data[0];
                String url = (String) data[1];
                if (!flagList.contains(queryId.toString())){
                    flagList.add(queryId.toString());
                    urlList.add(url);
                }
                else if(flagList.contains(queryId.toString()) &&  url.indexOf(queryId.toString()) >= 0){
                    continue;
                }
            }
        }
        return urlList;
    }
    public void updateAmazonTable(String uniqueId){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String queryString = "update AmazonData as data set data.isProcessed=True, data.lastModifiedDate =:dates WHERE data.uniqueCrawledId =:uniqueId";
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(queryString);
        query.setParameter("uniqueId", uniqueId);
        query.setParameter("dates", new Date());
        int updateCount=query.executeUpdate();
        System.out.println("Updated Count ==" + updateCount);
        entityManager.getTransaction().commit();
        entityManager.close();

    }



    public List<AmazonData> getCompetitiveSellersDetails(String asinNo)
    {

        System.out.println("In to Database");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Long data;
        Query query = entityManager.createQuery("SELECT  DISTINCT amazonData.queryId FROM ScrappingData amazonData where amazonData.asin =: asin ");
        query.setParameter("asin", asinNo);
        try{
            data = (long) query.getSingleResult();
        }
        catch (Exception e)
        {
            System.out.println("Exception is " + e);
            data=(long) 0;
        }

        System.out.println("Data after exception is" + data);
        System.out.println("Query Id are"+ data);
        Query competitorQuery = entityManager.createQuery("SELECT  amazonData FROM AmazonData amazonData where amazonData.queryId =: queryNumber order by amazonData.createdDate,amazonData.rank ");
        competitorQuery.setParameter("queryNumber",data);
        competitorQuery.setMaxResults(15);
        List<AmazonData> competitorDetails = competitorQuery.getResultList();
        if(competitorDetails.size()==0)
        {
            AmazonData competitorDetail = new AmazonData();
            competitorDetail.setQueryId((long)0);
            competitorDetails =Collections.singletonList(competitorDetail);

        }
        System.out.println("Amazon Data is "+ competitorDetails.size());
        entityManager.close();
        return competitorDetails;

    }

    public List<AmazonData> getTopSellers(int queryId, int number)

    {
        System.out.println("inside inside the getTopSellers"+ queryId +" "+ number);
        int maxResult=3;
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query competitorQuery=null;
        long queryNumber= queryId;
        List<AmazonData> competitorDetails=null;
        try{
            if(number==1)
            {
                System.out.println("Inside the 1");
                competitorQuery = entityManager.createQuery("SELECT  amazonData FROM AmazonData amazonData where amazonData.queryId =: queryNumber order by amazonData.createdDate,amazonData.rank  ");
                competitorQuery.setParameter("queryNumber",queryNumber);
                competitorQuery.setMaxResults(maxResult);
                competitorDetails = competitorQuery.getResultList();

            }
            else if (number==2)
            {
                System.out.println("Inside the 2");
                competitorQuery = entityManager.createQuery("SELECT  amazonData FROM AmazonData amazonData where amazonData.queryId =: queryNumber order by amazonData.createdDate,amazonData.rank DESC");
                competitorQuery.setParameter("queryNumber",queryNumber);
                competitorQuery.setMaxResults(maxResult);
                competitorDetails = competitorQuery.getResultList();

            }
            else
            {
                System.out.println("Inside the else");
                competitorQuery = entityManager.createQuery("SELECT  amazonData FROM AmazonData amazonData where amazonData.queryId =: queryNumber order by amazonData.createdDate,amazonData.rank ");
                competitorQuery.setParameter("queryNumber",queryNumber);

                competitorDetails = competitorQuery.getResultList();
                List<AmazonData> midCompetitor= new ArrayList<>();
                System.out.println("the size of sellers is "+ competitorDetails.size());
                System.out.println("the mid of sellers is "+ competitorDetails.size()/2);
                int mid=competitorDetails.size()/2;
                for(int i=mid-1;i<mid+2;i++)
                {
                    midCompetitor.add(competitorDetails.get(i));
                }
                return  midCompetitor;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally {
            entityManager.close();
        }

return competitorDetails;
    }



    public List<SellerCashflow> getSales(int sellerId)
    {
        Date last30Days= getEarlyDate();
       System.out.println("the seller id is "+sellerId );
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery("SELECT  turnOver FROM SellerCashflow turnOver  WHERE turnOver.sellerId = :sellerId AND turnOver.date > :date");
        query.setParameter("sellerId", sellerId);
        query.setParameter("date", last30Days);
        List<SellerCashflow> sales = query.getResultList();
        System.out.println(sales+""+sales.size());
        entityManager.close();
        return sales;
    }

    public List<AlgorithmData> getKeywords(long amazonId)
    {
        List<AlgorithmData> algorithmKeywords = null;

        try
        {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createQuery("SELECT  keywordData FROM AlgorithmData keywordData  WHERE keywordData.amazonDataId = :amazonId");
            query.setParameter("amazonId", amazonId);
             algorithmKeywords = query.getResultList();
            entityManager.close();

        }
        catch (Exception e)
        {
            System.out.println("exception is e");
        }
        return algorithmKeywords;
    }






}
