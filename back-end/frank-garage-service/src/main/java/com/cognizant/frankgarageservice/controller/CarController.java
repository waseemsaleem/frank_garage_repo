package com.cognizant.frankgarageservice.controller;

import com.cognizant.frankgarageservice.model.Car;
import com.cognizant.frankgarageservice.service.CarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/car")
public class CarController {

  @Autowired
  private CarService service;

  @GetMapping
  public List<Car> getAllCars() {
    return service.getAllCars();
  }

  @PostMapping
  public Car addCar(@RequestBody Car request) {
    return service.addCar(request);
  }
}
