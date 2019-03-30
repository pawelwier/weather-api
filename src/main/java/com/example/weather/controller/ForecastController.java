package com.example.weather.controller;

import com.example.weather.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForecastController {

    @Autowired
    ForecastService forecastService;

    @GetMapping("/forecast")
    public String getForeTemp(String city) {

        return forecastService.getForecastTemp(city);
    }

}
