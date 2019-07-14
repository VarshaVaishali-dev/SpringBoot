package com.weather.forecast.weatherForecast;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Varsha Vaishali on 13/07/2019.
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.weather.forecast.weatherForecast.Controller"})
//@EnableConfigurationProperties(WeatherForecastApplication.class)

public class WeatherForecastApplication implements CommandLineRunner {



	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {

		SpringApplication.run(WeatherForecastApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

}
