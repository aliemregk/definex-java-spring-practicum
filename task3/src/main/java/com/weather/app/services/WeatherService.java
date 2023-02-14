package com.weather.app.services;

import com.weather.app.responses.GetCurrentWeatherResponse;
import com.weather.app.responses.GetWeatherForecastResponse;

import reactor.core.publisher.Mono;

public interface WeatherService {

    Mono<GetCurrentWeatherResponse> getCurrentWeather(String city);

    Mono<GetWeatherForecastResponse> getWeatherForecast(String city, int days);
}
