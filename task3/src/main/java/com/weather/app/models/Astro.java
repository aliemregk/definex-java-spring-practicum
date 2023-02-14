package com.weather.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Astro {
    private String sunrise;
    private String sunset;
    private String moonrise;
    private String moonset;
    private String moonPhase;
    private String moon_illumination;
}
