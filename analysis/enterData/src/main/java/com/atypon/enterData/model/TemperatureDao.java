package com.atypon.enterData.model;

import lombok.AllArgsConstructor;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TemperatureDao {

    private final TemperatureRepository temperatureRepository;

    public void save(Temperature temperature) {
        temperatureRepository.save(temperature);
    }

    public List<Temperature> getTemperature() {
        List<Temperature> temp = new ArrayList<>();
        Streamable.of(temperatureRepository.findAll())
                .forEach(temp::add);
        return temp;
    }

}
