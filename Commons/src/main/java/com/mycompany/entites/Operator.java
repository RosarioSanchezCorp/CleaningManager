/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entites;

import java.io.Serializable;

/**
 *
 * @author adriel
 */
public class Operator implements Serializable{
    
    private static final long serialVersionUID = 1L;
    //atributes
    private Long id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private FoodTruck foodTruck;

    //Constuctors
    public Operator(String name, String lastName, String phoneNumber, FoodTruck foodTruck) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.foodTruck = foodTruck;
    }
    

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public FoodTruck getFoodTruck() {
        return foodTruck;
    }

    public void setFoodTruck(FoodTruck foodTruck) {
        this.foodTruck = foodTruck;
    }
    
}
