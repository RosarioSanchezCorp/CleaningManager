/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.serviceImpl;

import com.mycompany.dao.ApplicationContext;
import com.mycompany.dao.DaoAppliance;
import com.mycompany.dao.DaoEnum;
import com.mycompany.dao.DaoFoodTruck;
import com.mycompany.dao.DaoForm;
import com.mycompany.dao.DaoFormAppliance;
import com.mycompany.dao.DaoInspector;
import com.mycompany.dto.DtoAppliance;
import com.mycompany.dto.DtoFoodTruck;
import com.mycompany.dto.DtoForm;
import com.mycompany.dto.DtoFormAppliance;
import com.mycompany.dto.DtoInspector;
import com.mycompany.entities.Appliance;
import com.mycompany.entities.FoodTruck;
import com.mycompany.entities.Form;
import com.mycompany.entities.Inspector;
import com.mycompany.service.ServiceInspector;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adriel
 */
public class ServiceImplInspector implements ServiceInspector  {
    
    private DaoForm daoForm = (DaoForm) ApplicationContext.getDao(DaoEnum.DAO_FORM);
    private DaoAppliance daoAppliance = (DaoAppliance) ApplicationContext.getDao(DaoEnum.DAO_APPLIANCE);
    private DaoFormAppliance daoFormAppliance = (DaoFormAppliance) ApplicationContext.getDao(DaoEnum.DAO_FORM_APPLIANCE);
    private DaoInspector daoInspector = (DaoInspector) ApplicationContext.getDao(DaoEnum.DAO_INSPECTOR);
    private DaoFoodTruck daoFoodTruck = (DaoFoodTruck) ApplicationContext.getDao(DaoEnum.DAO_FOODTRUCK);
    
    @Override
    public void createForm(Form form) {
        DtoForm dtoForm = new DtoForm(form.getInspector().getId(), form.getFoodTruck().getId(), form.getInspectionTime(), form.getCleaningStatus(), form.getDescription());
        daoForm.create(dtoForm);
        for(Appliance appliance: form.getApplianceList()){
            DtoFormAppliance dtoFormAppliance = new DtoFormAppliance(daoForm.findLast().getId(), appliance.getId(), appliance.getCleaningStatus());
            daoFormAppliance.create(dtoFormAppliance);           
        }
    }
    
    @Override
    public List<Appliance> getApplianceList() {
        List<Appliance> applianceList = new ArrayList<>();
        for(DtoAppliance dtoAppliance: daoAppliance.findAll()){
            Appliance appliance = new Appliance(dtoAppliance.getId(), dtoAppliance.getName());
            applianceList.add(appliance);
        }
        return applianceList;
    }

    @Override
    public List<Inspector> getInspectorList() {
        List<Inspector> inspectorList = new ArrayList<>();
        
        
        for(DtoInspector dtoInspector: daoInspector.findAll()){
            List<FoodTruck> foodTruckList = new ArrayList<>();
            for(DtoFoodTruck dtoFoodTruck: daoFoodTruck.findAllFrom(dtoInspector.getId())){
                FoodTruck foodTruck = new FoodTruck(dtoFoodTruck.getId());
                foodTruckList.add(foodTruck);
            }
            Inspector inspector = new Inspector(dtoInspector.getId(), dtoInspector.getName(), dtoInspector.getLastName(), dtoInspector.getPhoneNumber(),foodTruckList);
            inspectorList.add(inspector);
        }
        return inspectorList;
    }

    @Override
    public List<FoodTruck> getFoodTruckList() {
        List<FoodTruck> foodTruckList = new ArrayList<>();
        for(DtoFoodTruck dtoFoodTruck: daoFoodTruck.findAll()){
            FoodTruck foodTruck = new FoodTruck(dtoFoodTruck.getId());
            foodTruckList.add(foodTruck);
        }
        return foodTruckList;
    }
    
    
    
}
