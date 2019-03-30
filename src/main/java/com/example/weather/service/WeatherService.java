package com.example.weather.service;

import com.example.weather.model.WeatherModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    RestTemplate restTemplate = new RestTemplate();

    public String getTemperature(String city) {

        if (city != null) {

            String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=ef2028e98b54649bf1f4c4582631f350";

            WeatherModel weatherModel = restTemplate.getForObject(url, WeatherModel.class);

            return weatherModel.getMain().getDegreeCelcius();
        }
        else {
            return null;
        }
    }

    public Integer getPressure(String city) {

        if (city != null) {

            String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=ef2028e98b54649bf1f4c4582631f350";

            WeatherModel weatherModel = restTemplate.getForObject(url, WeatherModel.class);

            return weatherModel.getMain().getPressure();
        } else {
            return null;
        }
    }

    public Integer getHumidity(String city){

            if (city != null) {

                String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=ef2028e98b54649bf1f4c4582631f350";

                WeatherModel weatherModel = restTemplate.getForObject(url, WeatherModel.class);

                return weatherModel.getMain().getHumidity();
            } else {
                return null;
            }
        }

    public Double getWindSpeed(String city){

                if (city != null) {

                    String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=ef2028e98b54649bf1f4c4582631f350";

                    WeatherModel weatherModel = restTemplate.getForObject(url, WeatherModel.class);

                    return weatherModel.getWind().getSpeed();
                } else {
                    return null;
                }
            }

    public String getDescription(String city) {

        if (city != null) {

            String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=ef2028e98b54649bf1f4c4582631f350";

            WeatherModel weatherModel = restTemplate.getForObject(url, WeatherModel.class);

            return weatherModel.getWeather()[0].getDescription();
        } else {
            return null;
        }
    }

    public String showConditionsPl(String en) {

        return en.equals("few clouds") ? "małe zachmurzenie" : (en.equals("mist") ? "mgła" :
                (en.equals("clear sky") ? "bezchmurne niebo" : (en.equals("light rain") ? "niewielkie opady deszczu" :
                        (en.equals("light intensity drizzle") ? "lekka mżawka" : (en.equals("scattered clouds") ?
                                "małe zachmurzenie" : (en.equals("broken clouds") ? "częściowe zachmurzenie" : "--"))))));

    }
}
