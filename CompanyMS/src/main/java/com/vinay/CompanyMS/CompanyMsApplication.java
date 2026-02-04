package com.vinay.CompanyMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class CompanyMsApplication {

	public static void main(String[] args) {
		// FORCE JVM timezone BEFORE Spring & Hibernate start
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

		SpringApplication.run(CompanyMsApplication.class, args);
	}
}
