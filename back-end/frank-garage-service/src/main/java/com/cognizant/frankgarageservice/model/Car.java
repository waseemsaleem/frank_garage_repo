package com.cognizant.frankgarageservice.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Car {

  private String name;
  private int milesPerGallon;
  private int cylinders;
  private int displacement;
  private int Horsepower;
  private BigDecimal price;
  private Double acceleration;
  private boolean licensed;
  private Date dateAdded;
  private String warehouse;

  public Car() {
  }

  public Car(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getMilesPerGallon() {
    return milesPerGallon;
  }

  public void setMilesPerGallon(int milesPerGallon) {
    this.milesPerGallon = milesPerGallon;
  }

  public int getCylinders() {
    return cylinders;
  }

  public void setCylinders(int cylinders) {
    this.cylinders = cylinders;
  }

  public int getDisplacement() {
    return displacement;
  }

  public void setDisplacement(int displacement) {
    this.displacement = displacement;
  }

  public int getHorsepower() {
    return Horsepower;
  }

  public void setHorsepower(int horsepower) {
    Horsepower = horsepower;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Double getAcceleration() {
    return acceleration;
  }

  public void setAcceleration(Double acceleration) {
    this.acceleration = acceleration;
  }

  public boolean isLicensed() {
    return licensed;
  }

  public void setLicensed(boolean licensed) {
    this.licensed = licensed;
  }

  public Date getDateAdded() {
    return dateAdded;
  }

  public void setDateAdded(Date dateAdded) {
    this.dateAdded = dateAdded;
  }

  public String getWarehouse() {
    return warehouse;
  }

  public void setWarehouse(String warehouse) {
    this.warehouse = warehouse;
  }
}
