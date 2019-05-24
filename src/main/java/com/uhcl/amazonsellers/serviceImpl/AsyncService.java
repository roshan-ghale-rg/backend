package com.uhcl.amazonsellers.serviceImpl;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {
    private static Logger log = LoggerFactory.getLogger(AsyncService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Async("asyncExecutor")
    public CompletableFuture<JSONObject> postData(String url, Map data) throws InterruptedException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<?> requestBody = new HttpEntity<>(data,headers);
        log.info("Send request with POST method.  "+url);
        ResponseEntity<?> result
                = restTemplate.postForEntity(url, requestBody, String.class);
        log.info("Status code:" + result.getStatusCode());
        JSONObject resultsRes = null;
        if (result.getStatusCode() == HttpStatus.OK || result.getStatusCode() == HttpStatus.ACCEPTED) {
            resultsRes = new JSONObject(result.getBody().toString());
            Thread.sleep(1000L);    //Intentional delay
            return CompletableFuture.completedFuture(resultsRes);
        }
        return null;

    }

}
