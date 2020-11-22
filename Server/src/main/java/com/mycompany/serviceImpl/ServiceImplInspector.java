/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.serviceImpl;

import com.mycompany.dao.ApplicationContext;
import com.mycompany.dao.DaoAppliance;
import com.mycompany.dao.DaoEnum;
import com.mycompany.dao.DaoForm;
import com.mycompany.dao.DaoFormAppliance;
import com.mycompany.dto.DtoAppliance;
import com.mycompany.dto.DtoForm;
import com.mycompany.dto.DtoFormAppliance;
import com.mycompany.entities.Appliance;
import com.mycompany.entities.Form;
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
    
    
    
}
