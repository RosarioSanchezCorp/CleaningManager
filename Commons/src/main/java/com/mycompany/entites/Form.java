/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entites;

import java.io.Serializable;
import java.sql.Date;
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
    private Date inspectionTime;
    private List<Appliance> appliancesList;
    private Boolean cleaningStatus;
    private String description;

    //contructors
    public Form(Inspector inspector, FoodTruck foodTruck, Date inspectionTime, List<Appliance> appliancesList, Boolean cleaningStatus, String description) {
        this.inspector = inspector;
        this.foodTruck = foodTruck;
        this.inspectionTime = inspectionTime;
        this.appliancesList = appliancesList;
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

    public Date getInspectionTime() {
        return inspectionTime;
    }

    public void setInspectionTime(Date inspectionTime) {
        this.inspectionTime = inspectionTime;
    }

    public List<Appliance> getAppliancesList() {
        return appliancesList;
    }

    public void setAppliancesList(List<Appliance> appliancesList) {
        this.appliancesList = appliancesList;
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
