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
import com.java.net.service.WeatherService;

import ch.qos.logback.classic.Logger;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/*
 * Author Rajesh kumar
 * */

@CrossOrigin
@RestController
@RequestMapping
@Slf4j
public class WeatherController {
	
	@Autowired
	private WeatherService  weatherService;

    @GetMapping("/weather/{location}")
    public ResponseEntity<WeatherData> current(@PathVariable String location) {
    	 WeatherData weatherData = null;
    	try {
            weatherData = weatherService.currentService(location);
            log.info("Data from Weather API "+weatherData.toString());
            return ResponseEntity.ok(weatherData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(weatherData);
        }
    }
}
