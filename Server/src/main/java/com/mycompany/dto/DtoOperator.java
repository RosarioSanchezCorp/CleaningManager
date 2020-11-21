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
public class DtoOperator implements Serializable {
    
    private Long id;
    private String name;
    private String lastName;
    private String phoneNumber;
    private Long idTruck;

    public DtoOperator(String name, String lastName, String phoneNumber, Long idTruck) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.idTruck = idTruck;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getIdTruck() {
        return idTruck;
    }

    public void setIdTruck(Long idTruck) {
        this.idTruck = idTruck;
    }
    
}
