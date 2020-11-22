/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author adriel
 */
public class Inspector implements Serializable{
    
    private static final long serialVersionUID = 1L;
    //atributes
    private Long id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private List<FoodTruck> truckList;

    //constructors
    public Inspector(String name, String lastName, String phoneNumber, List<FoodTruck> truckList) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.truckList = truckList;
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

    public List<FoodTruck> getTruckList() {
        return truckList;
    }

    public void setTruckList(List<FoodTruck> truckList) {
        this.truckList = truckList;
    }
    
    
    
}
