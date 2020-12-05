/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author adriel
 */
public class Form implements Serializable{
    
    private static final long serialVersionUID = 1L;
    //atributes
    private Long id;
    private Inspector inspector;
    private FoodTruck foodTruck;
    private Timestamp inspectionTime;
    private List<Appliance> applianceList;
    private Boolean cleaningStatus;
    private String description;

    //contructors
    public Form(Inspector inspector, FoodTruck foodTruck, Timestamp inspectionTime, List<Appliance> applianceList, Boolean cleaningStatus, String description) {
        this.inspector = inspector;
        this.foodTruck = foodTruck;
        this.inspectionTime = inspectionTime;
        this.applianceList = applianceList;
        this.cleaningStatus = cleaningStatus;
        this.description = description;
    }
    

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    public FoodTruck getFoodTruck() {
        return foodTruck;
    }

    public void setFoodTruck(FoodTruck foodTruck) {
        this.foodTruck = foodTruck;
    }

    public Timestamp getInspectionTime() {
        return inspectionTime;
    }

    public void setInspectionTime(Timestamp inspectionTime) {
        this.inspectionTime = inspectionTime;
    }

    public List<Appliance> getApplianceList() {
        return applianceList;
    }

    public void setAppliancesList(List<Appliance> applianceList) {
        this.applianceList = applianceList;
    }

    public Boolean getCleaningStatus() {
        return cleaningStatus;
    }

    public void setCleaningStatus(Boolean cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
