/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daoImpl;

import com.mycompany.dao.DaoAppliance;
import com.mycompany.dto.DtoAppliance;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adriel
 */
public class DaoImplAppliance implements DaoAppliance{
    
    private List<DtoAppliance> applianceDB = new ArrayList<>();
    
    //THIS IS JUST FOR TESTING
    public DaoImplAppliance(){
        DtoAppliance ap1 = new DtoAppliance("Stove");ap1.setId(1L);
        DtoAppliance ap2 = new DtoAppliance("toaster");ap2.setId(2L);
        DtoAppliance ap3 = new DtoAppliance("fan");ap3.setId(3L);
        applianceDB.add(ap1);
        applianceDB.add(ap2);
        applianceDB.add(ap3);
    }
    
    @Override
    public void create(DtoAppliance entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modify(DtoAppliance entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(DtoAppliance entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtoAppliance findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DtoAppliance> findAll() {
        return applianceDB;
    }
    
}
