package com.java.net;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import lombok.extern.slf4j.Slf4j;

/*
 * Author : Rajesh kumar
 * */
@Slf4j
@EnableEurekaServer
@SpringBootApplication
public class A1UniversalServiceRegistoryApplication {

	public static void main(String[] args) {
		log.info("Service Resgistry has been starting port : 8761");
		SpringApplication.run(A1UniversalServiceRegistoryApplication.class, args);
		log.info("Service Resgistry has been started port : 8761");
	}

}
