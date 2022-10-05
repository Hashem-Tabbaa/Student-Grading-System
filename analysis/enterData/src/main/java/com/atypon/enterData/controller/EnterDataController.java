package com.atypon.enterData.controller;

import com.atypon.enterData.model.Temperature;
import com.atypon.enterData.model.TemperatureDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class EnterDataController {

    private final TemperatureDao temperatureDao;

    @GetMapping("/enterData")
    public String enterData(Model model, HttpServletRequest request){
        if(request.getSession().getAttribute("username") == null){
            return "redirect:/login";
        }
        model.addAttribute("temperature", new Temperature());
        return "enterData";
    }

    @PostMapping("/enterData")
    public void enterDataPost(Temperature temperature){
        System.out.println("Saving the temperature");
        System.out.println(temperature.getTemperature_value());
        temperatureDao.save(temperature);
    }
}
