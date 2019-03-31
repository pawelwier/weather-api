package com.example.weather.controller;

import com.example.weather.model.ForecastModel;
import com.example.weather.service.ForecastService;
import com.example.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @Autowired
    ForecastService forecastService;

    @GetMapping("/")
    public String getWeatherDetails(@RequestParam (required = false) String city,
                                    ModelMap modelMap) {

        if (city == null) {return "main";}
        if (city.equals("")) {
            modelMap.put("warning", "Wpisz nazwę miasta");
        } else {

            modelMap.put("city", city);
            modelMap.put("temperature", weatherService.getTemperature(city));
            modelMap.put("pressure", weatherService.getPressure(city));
            modelMap.put("wind", weatherService.getWindSpeed(city));
            modelMap.put("humidity", weatherService.getHumidity(city));
            modelMap.put("description", weatherService.showConditionsPl(weatherService.getDescription(city)));
        }
        return "main";
    }

}
