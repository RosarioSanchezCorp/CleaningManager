/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daoImpl;

import com.mycompany.dao.DaoInspector;
import com.mycompany.dto.DtoInspector;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adriel
 */
public class DaoImplInspector implements DaoInspector{
    
    private List<DtoInspector> inspectorDB = new ArrayList<>();
    
    //THIS IS JUST FOR TESTING
    public DaoImplInspector(){
        DtoInspector inspector1 = new DtoInspector("Carlos", "Rosario", "8297842714");inspector1.setId(1L);
        DtoInspector inspector2 = new DtoInspector("Adriel", "Sanchez", "8095612312");inspector2.setId(2L);
        this.inspectorDB.add(inspector1);
        this.inspectorDB.add(inspector2);
    }
    
    @Override
    public void create(DtoInspector entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modify(DtoInspector entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(DtoInspector entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtoInspector findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DtoInspector> findAll() {
        return inspectorDB;
    }
    
}
