/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.supports;

import javafx.scene.control.CheckBox;

/**
 *
 * @author alex_rosario
 */
public class ApplianceRegistry {
    
    private String name;
    private CheckBox cb;
    
    public ApplianceRegistry(String name){
        this.name = name;
        this.cb = new CheckBox();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CheckBox getCb() {
        return cb;
    }

    public void setCb(CheckBox cb) {
        this.cb = cb;
    }
    
    
    
    
}
