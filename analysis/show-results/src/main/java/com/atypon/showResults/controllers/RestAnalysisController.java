package com.atypon.showResults.controllers;

import com.atypon.showResults.model.AnalysisMongo;
import com.atypon.showResults.services.AnalysisService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RestAnalysisController {

    private final AnalysisService analysisService;

    @GetMapping("/analysis/all")
    public List<AnalysisMongo> getAnalysis(){
        return analysisService.getAnalysis();
    }
}
