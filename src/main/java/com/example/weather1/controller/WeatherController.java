package com.example.weather1.controller;

import com.example.weather1.model.Weather;
import com.example.weather1.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city, Model model) {
        Weather weather = weatherService.getWeather(city); // Зберігаємо об'єкт Weather
        model.addAttribute("weather", weather);
        model.addAttribute("city", city);
        return "weather";
    }

}
