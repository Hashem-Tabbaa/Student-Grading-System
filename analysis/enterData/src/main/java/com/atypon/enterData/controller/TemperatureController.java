package com.atypon.enterData.controller;


import com.atypon.enterData.model.Temperature;
import com.atypon.enterData.model.TemperatureDao;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TemperatureController {

    private final TemperatureDao temperatureDao;

    @GetMapping("/temperature")
    public List<Temperature> getTemperature(){
        System.out.println("Getting the temperature");
        return temperatureDao.getTemperature();
    }

}
