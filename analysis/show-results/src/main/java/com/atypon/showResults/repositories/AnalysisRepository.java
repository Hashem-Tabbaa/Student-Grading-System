package com.atypon.showResults.repositories;

import com.atypon.showResults.model.AnalysisMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalysisRepository extends MongoRepository<AnalysisMongo, Long> {


}
