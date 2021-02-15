package com.cognizant.frankgarageservice.service;

import com.cognizant.frankgarageservice.model.Car;
import com.cognizant.frankgarageservice.repository.CarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

  @Autowired
  private CarRepository repository;

  public List<Car> getAllCars() {
    return repository.findAll();
  }

  public Car addCar(Car car) {
    return repository.save(car);
  }
}
