package com.uhcl.amazonsellers.comprehend;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.comprehend.AmazonComprehend;
import com.amazonaws.services.comprehend.AmazonComprehendClientBuilder;
import com.amazonaws.services.comprehend.model.DetectSentimentRequest;
import com.amazonaws.services.comprehend.model.DetectSentimentResult;

public class Comprehend {

	public static DetectSentimentResult calculateSentiment(String text) {
		
		BasicAWSCredentials awsCredentials=new BasicAWSCredentials("AKIAJZ7K7SGT2PDKWODQ", "qN4nht0JJxwO4hInLqCZ/jJp+EjuBJaNpG2uBOt0");
		
  
	AWSCredentialsProvider awsCreds = DefaultAWSCredentialsProviderChain.getInstance();
	
    AmazonComprehend comprehendClient =
        AmazonComprehendClientBuilder.standard()
                                     .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                                     .withRegion(Regions.US_EAST_2)
                                     .build();
    
System.out.println("Calling DetectSentiment");
DetectSentimentRequest detectSentimentRequest = new DetectSentimentRequest().withText(text)
                                                .withLanguageCode("en");
DetectSentimentResult detectSentimentResult = comprehendClient.detectSentiment(detectSentimentRequest);

return detectSentimentResult;
		
	}

}
