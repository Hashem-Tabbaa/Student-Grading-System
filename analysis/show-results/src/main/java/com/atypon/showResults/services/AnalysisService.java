package com.atypon.showResults.services;

import com.atypon.showResults.model.AnalysisMongo;
import com.atypon.showResults.repositories.AnalysisRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnalysisService {

    private final AnalysisRepository analysisRepository;

    public List<AnalysisMongo> getAnalysis() {
        return analysisRepository.findAll();
    }

}
