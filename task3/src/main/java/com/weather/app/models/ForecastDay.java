package com.weather.app.models;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForecastDay {
    private String date;
    private Day day;
    private Astro astro;
    private Collection<Hour> hour;
}
