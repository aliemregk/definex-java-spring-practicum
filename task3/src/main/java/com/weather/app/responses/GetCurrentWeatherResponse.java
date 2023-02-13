package com.weather.app.responses;

import com.weather.app.models.Location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.weather.app.models.Current;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCurrentWeatherResponse {
    private Location location;
    private Current current;
}
