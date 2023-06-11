package com.java.net;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.net.entity.WeatherData;
import com.java.net.service.WeatherService;

@RunWith(SpringRunner.class)
@SpringBootTest
class WeatherMapApIv2UnitTest {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private WeatherService weatherService;
	
	 @Test
	 @DisplayName("Check the service calling openweatherapi")
	 void testWatherService() {
		String location = "Goa";
	    WeatherData data = weatherService.currentService(location);
	    assertTrue(location.equals(data.getName()));
	 }
	
}
