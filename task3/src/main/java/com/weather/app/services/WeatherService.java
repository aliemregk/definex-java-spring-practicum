package com.weather.app.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.weather.app.responses.GetCurrentWeatherResponse;
import com.weather.app.responses.GetWeatherForecastResponse;

import reactor.core.publisher.Mono;

@Service
public class WeatherService {

    private final WebClient webClient;

    @Value("${api_key}")
    private String apiKey;

    public WeatherService() {
        this.webClient = WebClient.create("api.weatherapi.com/v1/");
    }

    public Mono<GetCurrentWeatherResponse> getCurrentWeather(String city) {
        return webClient.get()
                .uri("current.json?key=" + apiKey + "&q=" + city + "&aqi=no")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GetCurrentWeatherResponse.class);
    }

    public Mono<GetWeatherForecastResponse> getWeatherForecast(String city, int days) {
        return webClient.get()
                .uri("forecast.json?key=" + apiKey + "&q=" + city + "&days=" + days + "&aqi=no" + "&alerts=no")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GetWeatherForecastResponse.class);
    }
}
