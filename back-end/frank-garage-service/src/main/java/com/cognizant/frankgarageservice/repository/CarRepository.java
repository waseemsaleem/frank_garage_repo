package com.cognizant.frankgarageservice.repository;

import com.cognizant.frankgarageservice.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car, Long> {

}
