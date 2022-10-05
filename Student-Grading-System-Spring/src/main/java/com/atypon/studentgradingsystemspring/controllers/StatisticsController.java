package com.atypon.studentgradingsystemspring.controllers;

import com.atypon.studentgradingsystemspring.model.Statistics;
import com.atypon.studentgradingsystemspring.services.MarksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StatisticsController {

    private final MarksService marksService;

    public StatisticsController(MarksService marksService) {
        this.marksService = marksService;
    }

    @PostMapping("/statistics")
    public String statistics(String courseName, Model model, HttpServletRequest request){
        System.out.println("Post statistics");
        String username = request.getSession().getAttribute("username").toString();
        if(username == null || courseName == null){
            return "redirect:/login";
        }
        System.out.println(username);
        System.out.println(courseName);

        model.addAttribute("statistics", marksService.getStatistics(courseName));
        model.addAttribute("statistic", new Statistics());
        return "statistics";
    }


}
