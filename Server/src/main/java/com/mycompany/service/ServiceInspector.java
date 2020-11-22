/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.entities.Appliance;
import com.mycompany.entities.FoodTruck;
import com.mycompany.entities.Form;
import com.mycompany.entities.Inspector;
import java.util.List;

/**
 *
 * @author alex_rosario
 */
public interface ServiceInspector {
    
    public void createForm(Form form);
    public List<Appliance> getApplianceList();
    public List<Inspector> getInspectorList();
    public List<FoodTruck> getFoodTruckList();
    
}
