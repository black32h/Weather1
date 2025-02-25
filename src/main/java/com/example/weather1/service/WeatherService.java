package com.example.weather1.weatherservice;

import com.example.weather1.Weather;
import org.json.JSONException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.json.JSONObject;

@Service
public class WeatherService {

    @Value("${weather.api.key}") // ключ API
    private String apiKey;

    public Weather getWeather(String city) throws JSONException {
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric&lang=uk", city, apiKey);

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        if (response != null) {
            JSONObject jsonResponse = new JSONObject(response);
            double temperature = jsonResponse.getJSONObject("main").getDouble("temp");
            String description = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("description");

            Weather weather = new Weather(temperature, description);
            return weather;
        }
        return null;
    }
}
