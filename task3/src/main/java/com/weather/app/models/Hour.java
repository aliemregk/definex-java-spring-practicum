package com.weather.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hour {
    private String time;
    private double temp_c;
    private double temp_f;
    private Condition condition;
    private double wind_mph;
    private double wind_kph;
    private double wind_degree;
    private String wind_dir;
    private double humidity;
    private double cloud;
    private double feelslike_c;
    private double feelslike_f;
    private double will_it_rain;
    private double chance_of_rain;
    private double will_it_snow;
    private double chance_of_snow;
}
