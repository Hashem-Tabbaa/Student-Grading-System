package com.atypon.analyticsService.controller;

import com.atypon.analyticsService.model.Temperature;
import com.atypon.analyticsService.service.TemperatureAnalysisService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TemperatureAnalysisController {

    private final TemperatureAnalysisService temperatureAnalysisService;

    @GetMapping("/temperature/average")
    public Double getAverageTemperature() {
        System.out.println("Getting average temperature");
        return temperatureAnalysisService.getAverageTemperature();
    }

    @GetMapping("/temperature/min")
    public String getMinTemperature() {
        System.out.println("Getting min temperature");
        return temperatureAnalysisService.getMinTemperature().toString();
    }

    @GetMapping("/temperature/max")
    public String getMaxTemperature() {
        System.out.println("Getting max temperature");
        return temperatureAnalysisService.getMaxTemperature().toString();
    }

    @GetMapping("/temperature/all")
    public List<Temperature> getAllTemperatures() {
        System.out.println("Getting all temperatures");
        return (List<Temperature>) temperatureAnalysisService.getAllTemperatures();
    }
}
