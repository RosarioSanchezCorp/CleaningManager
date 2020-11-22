/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.daoImpl.DaoImplAppliance;
import com.mycompany.daoImpl.DaoImplFoodTruck;
import com.mycompany.daoImpl.DaoImplForm;
import com.mycompany.daoImpl.DaoImplFormAppliance;
import com.mycompany.daoImpl.DaoImplInspector;
import com.mycompany.daoImpl.DaoImplOperator;

/**
 *
 * @author alex_rosario
 */
public class ApplicationContext {
    
    public static GenericDao getDao(DaoEnum type){
        switch(type){
            case DAO_APPLIANCE:
                return new DaoImplAppliance();
            case DAO_FOODTRUCK:
                return new DaoImplFoodTruck();
            case DAO_FORM:
                return new DaoImplForm();
            case DAO_FORM_APPLIANCE:
                return new DaoImplFormAppliance();
            case DAO_INSPECTOR:
                return new DaoImplInspector();
            case DAO_OPERATOR:
                return new DaoImplOperator();
            default:
                return null;
        }
    }
    
}
