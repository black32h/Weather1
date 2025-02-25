package com.example.weather1.service;

import com.example.weather1.model.Weather;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.key}")
    private String apiKey;

    public Weather getWeather(String city) throws JSONException {
        String url = String.format(apiUrl, city, apiKey);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        if (response != null) {
            JSONObject jsonResponse = new JSONObject(response);
            double temperature = jsonResponse.getJSONObject("main").getDouble("temp");
            String description = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("description");

            // Перевод описания погоды на украинский
            String translatedDescription = translateWeatherDescription(description);

            return new Weather(temperature, translatedDescription);
        }
        return null;
    }

    // Метод для перевода
    private String translateWeatherDescription(String description) {
        switch (description) {
            case "clear sky":
                return "Ясне небо";
            case "few clouds":
                return "Невелика хмарність";
            case "scattered clouds":
                return "Розсіяні хмари";
            case "broken clouds":
                return "Перемінна хмарність";
            case "shower rain":
                return "Ливень";
            case "rain":
                return "Дощ";
            case "thunderstorm":
                return "Гроза";
            case "snow":
                return "Сніг";
            case "mist":
                return "Туман";
            default:
                return description; // В случае, если описание не найдено
        }
    }
}
