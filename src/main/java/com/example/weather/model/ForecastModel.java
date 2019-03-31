package com.example.weather.model;

import lombok.Data;

import java.text.DecimalFormat;

@Data
public class ForecastModel {

    private ForecastData[] list;

    public ForecastData findByDateAndTime(String date, String time) {

        ForecastData myData = new ForecastData();

        for (ForecastData forecastData : getList()) {
            if (forecastData.getDt_txt().contains(date + " " + time)) {
                myData = forecastData;
            }
        } return myData;
    }

    @Data
    public static class ForecastData {

        private ForecastInside main;

        private String dt_txt;


        @Data
        public static class ForecastInside {

            private Double temp;

            private Double pressure;

            private Integer humidity;

            public String getDegreeCelcius() {

                DecimalFormat decimalFormat = new DecimalFormat("##.##");

                return decimalFormat.format(getTemp() - 273);
            }

        }

    }

}
