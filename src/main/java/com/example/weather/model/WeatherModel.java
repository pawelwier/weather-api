package com.example.weather.model;

import lombok.Data;

import java.text.DecimalFormat;

@Data
public class WeatherModel {

    private WeatherData main;

    private WeatherData wind;

    private WeatherData[] weather;

    @Data
    public static class WeatherData {

        private Double temp;

        private Integer pressure;

        private Integer humidity;

        private Double speed;

        private String description;

        public String getDegreeCelcius() {

            DecimalFormat decimalFormat = new DecimalFormat("##.##");

            return decimalFormat.format(getTemp() - 273);
        }



    }

}
