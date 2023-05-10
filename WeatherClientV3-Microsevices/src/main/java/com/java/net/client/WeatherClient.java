package com.java.net.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * Author : Rajesh kumar
 * */


//@FeignClient(name = "weathermapapi" , url = "http://localhost:8088")
@FeignClient(name = "weathermapapi")
public interface WeatherClient {
	
	@RequestMapping(value = "/weather/{location}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getWeatherByLocation(@PathVariable("location") String loaction);

}
