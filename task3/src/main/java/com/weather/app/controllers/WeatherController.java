package com.weather.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.weather.app.responses.GetCurrentWeatherResponse;
import com.weather.app.responses.GetWeatherForecastResponse;
import com.weather.app.services.WeatherService;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/weather")
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(value = "/current")
    public Mono<GetCurrentWeatherResponse> getCurrentWeather(@RequestParam String city) {
        return weatherService.getCurrentWeather(city);
    }

    @GetMapping(value = "/forecast")
    public Mono<GetWeatherForecastResponse> getWeatherForecast(@RequestParam String city, @RequestParam int days) {
        return weatherService.getWeatherForecast(city, days);
    }

}
