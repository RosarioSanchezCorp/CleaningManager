/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.io.Serializable;

/**
 *
 * @author adriel
 */
public class Appliance {
    
    private static final long serialVersionUID = 1L;
    //atributes
    private Long id;
    private String name;
    private Boolean cleaningStatus;

    //constructors
    public Appliance(String name, Boolean cleaningStatus) {
        this.name = name;
        this.cleaningStatus = cleaningStatus;
    }
    
    public Appliance(Long id, String name) {
        this.name = name;
        this.id = id;
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

    public Boolean getCleaningStatus() {
        return cleaningStatus;
    }

    public void setCleaningStatus(Boolean cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
    }
    
    //methods 
    
}
