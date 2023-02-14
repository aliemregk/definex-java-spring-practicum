package com.weather.app.responses;

import com.weather.app.models.Current;
import com.weather.app.models.Forecast;
import com.weather.app.models.Location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetWeatherForecastResponse {
    private Location location;
    private Current current;
    private Forecast forecast;
}
