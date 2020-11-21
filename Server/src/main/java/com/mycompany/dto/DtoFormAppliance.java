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
public class DtoFormAppliance implements Serializable{
    
    private Long id;
    private Long idForm;
    private Long idAppliance;

    public DtoFormAppliance(Long idForm, Long idAppliance) {
        
        this.idForm = idForm;
        this.idAppliance = idAppliance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdForm() {
        return idForm;
    }

    public void setIdForm(Long idForm) {
        this.idForm = idForm;
    }

    public Long getIdAppliance() {
        return idAppliance;
    }

    public void setIdAppliance(Long idAppliance) {
        this.idAppliance = idAppliance;
    }
    
    
    
}
