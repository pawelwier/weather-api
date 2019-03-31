package com.example.weather.service;

import com.example.weather.model.ForecastModel;
import com.example.weather.model.WeatherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ForecastService {

    RestTemplate restTemplate = new RestTemplate();

    public String getForePressureByDateAndTime(String city, String date, String time) {

        if (city != null) {

            String url = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=ef2028e98b54649bf1f4c4582631f350";

            ForecastModel forecastModel = restTemplate.getForObject(url, ForecastModel.class);

            return "" + forecastModel.findByDateAndTime(date, time).getMain().getPressure();
        } else {
            return null;
        }
    }

    public String getForeTemperatureByDateAndTime(String city, String date, String time) {

        if (city != null) {

            String url = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=ef2028e98b54649bf1f4c4582631f350";

            ForecastModel forecastModel = restTemplate.getForObject(url, ForecastModel.class);

            return "" + forecastModel.findByDateAndTime(date, time).getMain().getDegreeCelcius();
        } else {
            return null;
        }
    }

    public String getForeHumidityByDateAndTime(String city, String date, String time) {

        if (city != null) {

            String url = "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=ef2028e98b54649bf1f4c4582631f350";

            ForecastModel forecastModel = restTemplate.getForObject(url, ForecastModel.class);

            return "" + forecastModel.findByDateAndTime(date, time).getMain().getHumidity();
        } else {
            return null;
        }
    }

}
