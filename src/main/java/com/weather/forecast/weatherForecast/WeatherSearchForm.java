package com.weather.forecast.weatherForecast;

import org.springframework.lang.NonNull;

/**
 * Created by Varsha Vaishali on 13/07/2019.
 */

public class WeatherSearchForm {
	
	@NonNull
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String toString() {
        return "WeatherSearchForm(City: " + this.city + ")";
    }
}
