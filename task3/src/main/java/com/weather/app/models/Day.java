package com.weather.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Day {
    private double maxtemp_c;
    private double maxtemp_f;
    private double mintemp_c;
    private double mintemp_f;
    private double avgtemp_c;
    private double avgtemp_f;
    private double maxwind_mph;
    private double maxwind_kph;
    private double totalsnow_cm;
    private double avgvis_km;
    private double avgvis_miles;
    private double avghumidity;
    private double daily_will_it_rain;
    private double daily_chance_of_rain;
    private double daily_will_it_snow;
    private double daily_chance_of_snow;
    private Condition condition;
    private double uv;
}
