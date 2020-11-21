/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dto;

import java.io.Serializable;

/**
 *
 * @author alex_rosario
 */
public class DtoAppliance implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private boolean cleaningStatus;

    public DtoAppliance(String name, boolean cleaningStatus) {
        
        this.name = name;
        this.cleaningStatus = cleaningStatus;
    }

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

    public boolean isCleaningStatus() {
        return cleaningStatus;
    }

    public void setCleaningStatus(boolean cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
    }
    
    
    
}
