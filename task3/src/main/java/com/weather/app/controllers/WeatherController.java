package com.weather.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import com.weather.app.constants.Messages;
import com.weather.app.responses.GetCurrentWeatherResponse;
import com.weather.app.responses.GetWeatherForecastResponse;
import com.weather.app.services.WeatherService;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/weather")
@Validated
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(value = "/current")
    public Mono<GetCurrentWeatherResponse> getCurrentWeather(
            @RequestParam 
            @NotNull(message = Messages.NULL_MESSAGE) 
            @NotBlank(message = Messages.BLANK_MESSAGE) 
            @Size(min = 2, message = Messages.SIZE_MESSAGE) 
            String city
        ) {
        return weatherService.getCurrentWeather(city);
    }

    @GetMapping(value = "/weeklyforecast")
    public Mono<GetWeatherForecastResponse> getWeeklyWeatherForecast(
            @RequestParam 
            @NotNull(message = Messages.NULL_MESSAGE) 
            @NotBlank(message = Messages.BLANK_MESSAGE) 
            @Size(min = 2, message = Messages.SIZE_MESSAGE) 
            String city
        ) {
        final int WEEK = 7;
        return weatherService.getWeatherForecast(city, WEEK);
    }

    @GetMapping(value = "/monthlyforecast")
    public Mono<GetWeatherForecastResponse> getMonthlyWeatherForecast(
            @RequestParam 
            @NotNull(message = Messages.NULL_MESSAGE) 
            @NotBlank(message = Messages.BLANK_MESSAGE) 
            @Size(min = 2, message = Messages.SIZE_MESSAGE)
            String city
        ) {
        final int MONTH = 30;
        return weatherService.getWeatherForecast(city, MONTH);
    }

}
