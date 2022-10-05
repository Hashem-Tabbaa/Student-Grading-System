package com.atypon.analyticsService.controller;

import com.atypon.analyticsService.model.AnalysisMongo;
import com.atypon.analyticsService.service.StoreAnalysisService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StoreAnalysisController {

    private final StoreAnalysisService storeAnalysisService;

    @PostMapping("/store")
    public AnalysisMongo storeAnalysis(AnalysisMongo analysisMongo){
        analysisMongo = new AnalysisMongo("average", 10.0);
        System.out.println("Storing analysis in controller: " + analysisMongo);
        return storeAnalysisService.storeAnalysis(analysisMongo);
    }

    @GetMapping("/analysis")
    public Iterable<AnalysisMongo> getAnalysis(){
        return storeAnalysisService.getAllAnalysis();
    }

}
