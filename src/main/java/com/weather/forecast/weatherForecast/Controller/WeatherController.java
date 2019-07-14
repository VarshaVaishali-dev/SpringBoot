package com.weather.forecast.weatherForecast.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Created by Varsha Vaishali on 13/07/2019.
 */


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.*;
//import org.slf4j.LoggerFactory;

//import com.weather.forecast.weatherForecast.WeatherAppProperties;
import com.weather.forecast.weatherForecast.WeatherSearchForm;
import com.weather.forecast.weatherForecast.service.Weather;
import com.weather.forecast.weatherForecast.service.WeatherServiceImpl;
import org.springframework.web.client.RestTemplate;

@Controller

public class WeatherController {
	
	
	private static final Logger LOGGER = Logger.getLogger(WeatherController.class);
	
	//private final WeatherAppProperties properties;
	private Weather Weather;
//	public WeatherController(Weather Weather, WeatherAppProperties properties) {
//		this.Weather = Weather;
//		this.properties = properties;
//	}
//	@RequestMapping(value="/weather_search")
//    public String index(){
//        System.out.println("Home Page");
//        return "weather_search";
//    }
	@RequestMapping(value = "/weather_search", method = RequestMethod.GET)
	public ModelAndView showWeatherSearchForm() {
		
		LOGGER.info("coming into the method*****************");
		
		return new ModelAndView("weather_search", "WeatherSearchForm", new WeatherSearchForm());
	}
	
		@RequestMapping(value = "/weather_summary", method = RequestMethod.POST)
		public ModelAndView weather_summary(@ModelAttribute WeatherSearchForm WeatherSearchform) {
			
		    
			LOGGER.info("Requesting current weather for {}");
			
			
		
			String view = "weather_search";
			//WeatherServiceImpl WeatherServiceImpl=new WeatherServiceImpl();
			//Weather result=WeatherServiceImpl.getweatherDetails(WeatherSearchform.getCity());
			RestTemplate restTemplate = null; ;
			WeatherServiceImpl WeatherServiceImpl=new WeatherServiceImpl();
			Weather result = WeatherServiceImpl.getweatherDetails(WeatherSearchform.getCity());
			
			ModelAndView ModelAndView=new ModelAndView();
			ModelAndView.setViewName("weather_summary");
			ModelAndView.addObject("WeatherSearchform",result);
			
			
			LOGGER.info("City:"+result.getTemperature());
			LOGGER.info("result:"+result.getName());
		
			return ModelAndView;
	}
	
}