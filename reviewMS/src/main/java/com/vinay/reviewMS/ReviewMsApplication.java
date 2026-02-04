package com.vinay.reviewMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.TimeZone; // <--- 1. ADD THIS IMPORT

@SpringBootApplication
public class ReviewMsApplication {

	public static void main(String[] args) {
		// 2. ADD THIS LINE AS THE FIRST LINE IN MAIN
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

		SpringApplication.run(ReviewMsApplication.class, args);
	}

}