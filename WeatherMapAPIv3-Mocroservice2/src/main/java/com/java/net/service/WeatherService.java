package com.java.net.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.net.entity.Clouds;
import com.java.net.entity.Coord;
import com.java.net.entity.Main;
import com.java.net.entity.Sys;
import com.java.net.entity.Weather;
import com.java.net.entity.WeatherData;
import com.java.net.entity.Wind;
import com.java.net.exception.LocationNotFoundException;
import com.java.net.util.PropertiesConfig;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

/*
 * Author Rajesh kumar
 * */


@Service
@Slf4j
public class WeatherService {
	
	@Autowired
	private PropertiesConfig propertiesConfig;

	public WeatherData currentService(String location) {
		WeatherData weatherData = new WeatherData();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = null;
        try {
        	URL urlObj = new URL( decode(propertiesConfig.getEncodedUrl()) + location + "&appid=" + decode(propertiesConfig.getEncodedAppId())+"&units=metric");
            log.info(urlObj.toExternalForm());
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder responseBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    responseBuilder.append(line);
                }
                jsonString = responseBuilder.toString();
            }
            
            weatherData = objectMapper.readValue(jsonString, WeatherData.class);
        } catch (Exception e) {
        	e.printStackTrace();
        	weatherData = new WeatherData();
            weatherData.setCod(404);
            return weatherData;
     //   	throw new LocationNotFoundException("No Customer found for the provided id.");
        }
		return weatherData;
	}
	
	
    public String decode(String toDecode) {
        byte[] decodedBytes = Base64.getDecoder().decode(toDecode);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
}
