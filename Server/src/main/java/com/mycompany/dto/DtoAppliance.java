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
    

    public DtoAppliance(String name) {
        
        this.name = name;
    }

    public DtoAppliance() {
        
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
}
