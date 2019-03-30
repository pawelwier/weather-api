package com.example.weather.model;

import lombok.Data;

import java.text.DecimalFormat;

@Data
public class ForecastModel {

    private ForecastData[] list;

    @Data
    public static class ForecastData {

        private ForecastInside main;


        @Data
        public static class ForecastInside {

            private Double temp;

            public String getDegreeCelcius() {

                DecimalFormat decimalFormat = new DecimalFormat("##.##");

                return decimalFormat.format(getTemp() - 273);
            }

        }

    }

}
