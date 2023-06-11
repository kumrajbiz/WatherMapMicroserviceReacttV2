package com.java.net;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.net.controller.WeatherController;
import com.java.net.entity.WeatherData;

@RunWith(SpringRunner.class)
@SpringBootTest
class WeatherMapApIv2IntegrationTest {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private WeatherController weatherController;
	
	 @Test
	 @DisplayName("Check the Controller calling Service methods")
	 void testWatherService() {
		String location = "Goa";
	    ResponseEntity<WeatherData> data = weatherController.current(location);
	    assertTrue(data.getStatusCode().is2xxSuccessful());
	    //assertNotNull(data.getHeaders().getLocation());
	 }
	
}
