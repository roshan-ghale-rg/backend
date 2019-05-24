package com.uhcl.amazonsellers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("com.uhcl.amazonsellers")
@SpringBootApplication
public class AmazonSellersApplication  {

	public static void main(String[] args) {
		SpringApplication.run(AmazonSellersApplication.class, args);
	}

}

