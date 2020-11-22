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
    
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long idForm;
    private Long idAppliance;
    private boolean cleaningStatus;

    public DtoFormAppliance(Long idForm, Long idAppliance, boolean cleaningStatus) {
        
        this.idForm = idForm;
        this.idAppliance = idAppliance;
        this.cleaningStatus = cleaningStatus;
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

    public boolean isCleaningStatus() {
        return cleaningStatus;
    }

    public void setCleaningStatus(boolean cleaningStatus) {
        this.cleaningStatus = cleaningStatus;
    }
    
    
    
}
