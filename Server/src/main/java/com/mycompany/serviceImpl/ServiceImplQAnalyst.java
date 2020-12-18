/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.serviceImpl;

import com.mycompany.dao.ApplicationContext;
import com.mycompany.dao.DaoEnum;
import com.mycompany.dao.DaoFormAppliance;
import com.mycompany.supports.Registry;
import com.mycompany.service.ServiceQAnalyst;
import java.util.List;

/**
 *
 * @author alex_rosario
 */
public class ServiceImplQAnalyst implements ServiceQAnalyst{
    
    private DaoFormAppliance daoFormAppliance = (DaoFormAppliance) ApplicationContext.getDao(DaoEnum.DAO_FORM_APPLIANCE);
    
    @Override
    public List<Registry> getRegistryList() {
        return daoFormAppliance.findAllRegistries();
    }

    @Override
    public Registry getLastRegistry() {
        int size = daoFormAppliance.findAllRegistries().size();
        final int c = size;
        while(c == daoFormAppliance.findAllRegistries().size()){
            //WAITING FOR A FORM, WNHEN ANY INSPECTOR SEND A FORM, THIS CYCLE WILL BREAK THEN THE LAST REGISTRY WILL BE RETURNED
        }  
        return daoFormAppliance.findLast();
    }
    
}
