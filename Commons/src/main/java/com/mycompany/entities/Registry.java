/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author alex_rosario
 */
public class Registry implements Serializable {
    
    private Long id;
    private String inspectorName;
    private String inspectorPhoneNumber;
    private Date inspectionTime;
    private Long idFoodTruck;
    private boolean cleaningStatus;
    private String operatorName;
    private String operatorPhoneNumber;
    private String description;

    public Registry(Long id, String inspectorName, String inspectorPhoneNumber, Date inspectionTime, Long idFoodTruck, boolean cleaningStatus, String operatorName, String operatorPhoneNumber, String description) {
        this.id = id;
        this.inspectorName = inspectorName;
        this.inspectorPhoneNumber = inspectorPhoneNumber;
        this.inspectionTime = inspectionTime;
        this.idFoodTruck = idFoodTruck;
        this.cleaningStatus = cleaningStatus;
        this.operatorName = operatorName;
        this.operatorPhoneNumber = operatorPhoneNumber;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public void setInspectorName(String inspectorName) {
        this.inspectorName = inspectorName;
    }

    public String getInspectorPhoneNumber() {
        return inspectorPhoneNumber;
    }

    public void setInspectorPhoneNumber(String inspectorPhoneNumber) {
        this.inspectorPhoneNumber = inspectorPhoneNumber;
    }

    public Date getInspectionTime() {
        return inspectionTime;
    }

    public void setInspectionTime(Date inspectionTime) {
        this.inspectionTime = inspectionTime;
    }

    public Long getIdFoodTruck() {
        return idFoodTruck;
    }

    public void setIdFoodTruck(Long idFoodTruck) {
        this.idFoodTruck = idFoodTruck;
    }

    public boolean isCleaningStatus() {
        return cleaningStatus;
    }

    public void setCleaningStatus(boolean cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorPhoneNumber() {
        return operatorPhoneNumber;
    }

    public void setOperatorPhoneNumber(String operatorPhoneNumber) {
        this.operatorPhoneNumber = operatorPhoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
