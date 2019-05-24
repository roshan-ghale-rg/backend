package com.uhcl.amazonsellers.Utilities;


import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HttpUtilities is based request and response to connect  amazon webservices.
 */
public class HttpUtilities {

    /**
     * Connect to the mws
     * @param queryBuilder  is a map that holds the extra key value pair that are needed to be send to the MWS
     *
     * @return String response from mws.
     * @throws IOException
     */
    public static String postRequest(Map<String,String> queryBuilder) throws IOException {

        String url = "mws.amazonservices.com";
        StringBuffer result = new StringBuffer();

        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            HttpPost post = new HttpPost(url);
            // add header
            post.setHeader("Content-Type", "x-www-form-urlencoded");
            post.setHeader("User-Agent","Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.90 Safari/537.36");
            List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
            urlParameters.add(new BasicNameValuePair("AWSAccessKeyId", "AKIAIGFE3C33MAIVCTBA"));
            urlParameters.add(new BasicNameValuePair("MarketplaceId", "ATVPDKIKX0DER"));
           // urlParameters.add(new BasicNameValuePair("Action", "ListMatchingProducts"));
            urlParameters.add(new BasicNameValuePair("MWSAuthToken", ""));
            urlParameters.add(new BasicNameValuePair("Signature",""));
            urlParameters.add(new BasicNameValuePair("SignatureVersion","2"));
            urlParameters.add(new BasicNameValuePair("Version","2011-10-01 "));
            urlParameters.add(new BasicNameValuePair("Timestamp", DateUtilities.getCurrentTimeStampInstant()));
            if (queryBuilder.entrySet() != null) {
                for (String entry : queryBuilder.keySet()) {
                    urlParameters.add(new BasicNameValuePair(entry.toString(),queryBuilder.get(entry)));
                }
            }

            post.setEntity(new UrlEncodedFormEntity(urlParameters));
            // HttpResponse response = client.execute(post);
            org.apache.http.HttpResponse response = client.execute(post);
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + post.getEntity());
            System.out.println("Response Code : " +
                    response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == 201 || response.getStatusLine().getStatusCode() == 200) {
                BufferedReader rd = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));

                String line = "";
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }
                System.out.println(result.toString());

            }

            // use httpClient (no need to close it explicitly)

        } catch (IOException e) {

            // handle

        }
        //TODO Handling the XML

        return result.toString();

    }
    public static void getRequest(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "endpoint url";
        String requestJson = "{\"I am alive\":\"App name?\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
        String answer = restTemplate.postForObject(url, entity, String.class);
        System.out.println(answer);

    }

    public static JSONObject postRequest(String url, Map data){

        RestTemplate restTemplate = new RestTemplate();

        // Data attached to the request.
        HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<?> requestBody = new HttpEntity<>(data,headers);

        System.out.println("Send request with POST method.  "+url);
        ResponseEntity<?> result
                = restTemplate.postForEntity(url, requestBody, String.class);

        System.out.println("Status code:" + result.getStatusCode());
        JSONObject resultsRes = null;
        if (result.getStatusCode() == HttpStatus.OK || result.getStatusCode() == HttpStatus.ACCEPTED) {
           // System.out.println("Status body:" + result.getBody());
            resultsRes = new JSONObject(result.getBody().toString());

          System.out.println("(Client Side) Data Received: "+ resultsRes);
        }
        return resultsRes;

    }

}
