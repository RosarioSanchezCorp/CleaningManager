/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.entites.Appliance;
import com.mycompany.entites.Form;
import java.util.List;

/**
 *
 * @author alex_rosario
 */
public interface ServiceInspector {
    
    public void createForm(Form form);
    public List<Appliance> getAppliances();
    
}
