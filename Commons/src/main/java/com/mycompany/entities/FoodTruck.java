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
public class FoodTruck implements Serializable{
    
    private static final long serialVersionUID = 1L;
    //atributes
    private Long id;

    public FoodTruck(Long id) {
        this.id = id;
    }
    
    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
