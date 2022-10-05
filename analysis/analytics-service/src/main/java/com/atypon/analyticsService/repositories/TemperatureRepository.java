package com.atypon.analyticsService.repositories;

import com.atypon.analyticsService.model.Temperature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends CrudRepository<Temperature, Long> {

}
