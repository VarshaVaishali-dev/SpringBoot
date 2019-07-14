package com.weather.forecast.weatherForecast.service;

import org.springframework.http.MediaType;
import java.net.URI;
import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

//import com.weather.forecast.weatherForecast.WeatherAppProperties;
import com.weather.forecast.weatherForecast.Controller.WeatherController;

/**
 * Created by Varsha Vaishali on 13/07/2019.
 */

@Service

public class WeatherServiceImpl {
	
	
	private static final Logger LOGGER = Logger.getLogger(WeatherServiceImpl.class);
	
//	private final String apiUrl;
//	
//	private final RestTemplate restTemplate;
//
//	private final String apiKey;
	
//	public WeatherServiceImpl(RestTemplate restTemplate, WeatherAppProperties properties) {
//		this.restTemplate = restTemplate;
//		this.apiKey = properties.getApi().getKey();
//		this.apiUrl = properties.getApi().getUrl();
//	}
	
	@Value("${part1}")
	String part1;
	public Weather  getweatherDetails(String City)
	{
		
		System.out.println("**************>"+part1);
//		System.out.println("apiKey: "+apiKey);
//		System.out.println("apiUrl: "+apiUrl);
//		URI uri = new UriTemplate(this.apiUrl).expand(City, this.apiKey);
		final String uri = "http://api.openweathermap.org/data/2.5/weather?q="+City+"&appid=0381a21a3e30bfd1d5c0451caf854875";
		
		RestTemplate restTemplate = new RestTemplate();
		Weather result = restTemplate.getForObject(uri, Weather.class);
		System.out.println(result);
		return result;
	}
}
