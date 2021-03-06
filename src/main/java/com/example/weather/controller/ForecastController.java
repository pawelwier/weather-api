package com.example.weather.controller;

import com.example.weather.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;

@Controller
public class ForecastController {

    @Autowired
    ForecastService forecastService;

    @GetMapping("/forecast")
    public String getForePressureForDate(@RequestParam (required = false) String city,
                                         @RequestParam (required = false) String date,
                                         @RequestParam (required = false) String time,
                                         ModelMap modelMap) throws ParseException {

        if (city == null || date == null) {return "forecast";}
        if (city.equals("") || date.equals("")) {
            modelMap.put("warning", "Wpisz miasto i datę.");
        } else {

            if (ForecastService.checkIfFiveDaysToDate(date)) {

                modelMap.put("city", city);
                modelMap.put("date", date);
                modelMap.put("time", time + ":00");
                modelMap.put("temperature", forecastService.getForeTemperatureByDateAndTime(city, date, time));
                modelMap.put("pressure", forecastService.getForePressureByDateAndTime(city, date, time));
                modelMap.put("humidity", forecastService.getForeHumidityByDateAndTime(city, date, time));
            }

            else {
                modelMap.put("warning", "Wybierz datę od jutra do max. pięciu dni w przód.");
            }

        }
        return "forecast";
    }


}
