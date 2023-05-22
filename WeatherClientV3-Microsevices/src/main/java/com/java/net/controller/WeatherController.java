package com.java.net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.net.entity.WeatherData;
import com.java.net.service.WeatherServiceimpl;

import lombok.extern.slf4j.Slf4j;

/*
 * Author : Rajesh kumar
 * */


@RestController
@RequestMapping
//@CrossOrigin(origins = "http://172.17.0.1:1234/")
@CrossOrigin("*")
@Slf4j
public class WeatherController {

   
    @Autowired
    private WeatherServiceimpl weatherService;
    
//    @CrossOrigin
    @GetMapping("/weather/{location}")
    public ResponseEntity<WeatherData> getWeatherByLocation(@PathVariable("location") String location) {
    	WeatherData weather = null;
    	System.out.println("Hitting Controller of Client with location"+ location);
    	try {
    		weather = weatherService.getWeatherByLocation(location);
    		log.info("Data from Weather Client for : "+location+" : "+weather.toString());
    		return ResponseEntity.ok(weather);
        } catch (Exception e) {
        	weather = new WeatherData();
        	weather.setCod(404);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(weather);
        }
      }
	}
