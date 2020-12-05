/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author alex_rosario
 */
public class DtoForm implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long idInspector;
    private Long idTruck;
    private Timestamp inspectionTime;
    private boolean cleaningStatus;
    private String description;

    public DtoForm(Long idInspector, Long idTruck, Timestamp inspectionTime, boolean cleaningStatus, String description) {
        this.idInspector = idInspector;
        this.idTruck = idTruck;
        this.inspectionTime = inspectionTime;
        this.cleaningStatus = cleaningStatus;
        this.description = description;
    }

    public DtoForm() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdInspector() {
        return idInspector;
    }

    public void setIdInspector(Long idInspector) {
        this.idInspector = idInspector;
    }

    public Long getIdTruck() {
        return idTruck;
    }

    public void setIdTruck(Long idTruck) {
        this.idTruck = idTruck;
    }

    public Timestamp getInspectionTime() {
        return inspectionTime;
    }

    public void setInspectionTime(Timestamp inspectionTime) {
        this.inspectionTime = inspectionTime;
    }

    public boolean getCleaningStatus() {
        return cleaningStatus;
    }

    public void setCleaningStatus(boolean cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
