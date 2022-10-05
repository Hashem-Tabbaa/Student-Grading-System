package com.atypon.analyticsService.service;

import com.atypon.analyticsService.model.AnalysisMongo;
import com.atypon.analyticsService.repositories.AnalysisRepository;
import com.mysql.cj.xdevapi.UpdateResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StoreAnalysisService {

    private final AnalysisRepository analysisRepository;

    public void storeAnalysis(String analysis_type, Double value, String _id) {
        AnalysisMongo analysisMongo = new AnalysisMongo();
        analysisMongo.setAnalysis_type(analysis_type);
        analysisMongo.setValue(value);
        analysisMongo.set_id(_id);
        analysisRepository.save(analysisMongo);
    }

    public AnalysisMongo storeAnalysis(AnalysisMongo analysisMongo) {
        System.out.println("Storing analysis into mongodb: " + analysisMongo);
        return analysisRepository.save(analysisMongo);
    }

    public Iterable<AnalysisMongo> getAllAnalysis() {
        return analysisRepository.findAll();
    }

}
