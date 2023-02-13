package com.weather.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Current {
    private String last_updated;
    private double temp_c;
    private double temp_f;
    private Condition condition;
    private double wind_mph;
    private double wind_kph;
    private double wind_degree;
    private String wind_dir;
    private double humidity;
    private double feelslike_c;
    private double feelslike_f;
}
