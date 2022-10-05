package com.atypon.enterData;

import com.atypon.enterData.model.TemperatureRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
@EnableAutoConfiguration
public class EnterDataApplication{

    TemperatureRepository temperatureRepository;

    public static void main(String[] args) {
        System.out.println("EnterDataApplication with mysql and enter data page");
        SpringApplication.run(EnterDataApplication.class, args);
    }
}
