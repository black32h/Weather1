package com.example.weather1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private static final List<String> CITIES = List.of(
            "Київ", "Львів", "Одеса", "Дніпро", "Харків", "Запоріжжя",
            "Івано-Франківськ", "Тернопіль", "Чернівці", "Вінниця",
            "Черкаси", "Полтава", "Суми", "Рівне"
    );

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("cities", CITIES);
        return "weather"; // Назва Thymeleaf-шаблону (weather.html)
    }
}
