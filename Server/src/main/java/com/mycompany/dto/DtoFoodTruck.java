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
public class DtoFoodTruck implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long idInspector;

    public DtoFoodTruck(Long idInspector) {
        this.idInspector = idInspector;
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
    
    
    
}
