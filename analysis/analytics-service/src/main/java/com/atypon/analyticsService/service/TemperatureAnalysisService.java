package com.atypon.analyticsService.service;

import com.atypon.analyticsService.model.Temperature;
import com.atypon.analyticsService.repositories.TemperatureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TemperatureAnalysisService {

    private final TemperatureRepository temperatureRepository;

    public Double getAverageTemperature() {
        List<Temperature> temperatures = (List<Temperature>) temperatureRepository.findAll();

        return temperatures.stream().mapToDouble(Temperature::getTemperature_value)
                .average()
                .orElse(0.0);
    }

    public Double getMinTemperature(){
        List<Temperature> temperatures = (List<Temperature>) temperatureRepository.findAll();

        return temperatures.stream().mapToDouble(Temperature::getTemperature_value)
                .min().orElse(0.0);
    }

    public Double getMaxTemperature(){
        List<Temperature> temperatures = (List<Temperature>) temperatureRepository.findAll();

        return temperatures.stream().mapToDouble(Temperature::getTemperature_value)
                .max().orElse(0.0);
    }

    public List<Temperature> getAllTemperatures() {
        return (List<Temperature>) temperatureRepository.findAll();
    }
}
