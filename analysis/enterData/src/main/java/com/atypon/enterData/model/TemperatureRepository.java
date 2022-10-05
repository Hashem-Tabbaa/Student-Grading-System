package com.atypon.enterData.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemperatureRepository extends CrudRepository<Temperature, Long> {

}
