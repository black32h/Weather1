package com.example.weather1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        List<String> cities = List.of("Київ", "Львів", "Одеса", "Дніпро", "Харків", "Запоріжжя",
                "Івано-Франківськ", "Тернопіль", "Чернівці", "Вінниця",
                "Черкаси", "Полтава", "Суми", "Рівне");

        model.addAttribute("cities", cities);
        return "weather"; // Назва Thymeleaf-шаблону (weather.html)
    }
}
