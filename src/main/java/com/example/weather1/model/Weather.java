package com.example.weather1.model;

public class Weather {
    private String temperature;
    private String description;

    // Конструктор, геттери і сеттери
    public Weather(double temperature, String description) {
        this.temperature = String.valueOf(temperature);
        this.description = description;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
