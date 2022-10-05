package com.atypon.analyticsService.repositories;

import com.atypon.analyticsService.model.AnalysisMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalysisRepository extends MongoRepository<AnalysisMongo, Long> {


}
