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
public class Appliances {
    
    //atributes
    private Long id;
    private String name;
    private Boolean cleaningStatus;

    //constructors
    public Appliances(String name, Boolean cleaningStatus) {
        this.name = name;
        this.cleaningStatus = cleaningStatus;
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
    
    
    
}
