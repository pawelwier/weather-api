package com.example.weather.service;

import com.example.weather.model.ForecastModel;
import com.example.weather.model.WeatherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    public static String addFiveDaysToDate(String previousDate) throws ParseException {

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf1.parse(previousDate));
        c.add(Calendar.DATE, 5);
        String newDate = sdf1.format(c.getTime());

        return newDate;
    }

    public static Boolean checkIfFiveDaysToDate(String newString) throws ParseException {

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

        Date newDate = sdf1.parse(newString);

        Date currentDate = new Date();
        String currentString = sdf1.format(currentDate);

        String plusString = addFiveDaysToDate(currentString);


        Date plusDate = sdf1.parse(plusString);

        if ((newDate.equals(plusDate)) || (newDate.before(plusDate)) &&
                (newDate.equals(currentDate) || newDate.after(currentDate))) return true;
        else return false;
    }

}
