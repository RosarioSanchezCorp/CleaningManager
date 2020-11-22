/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daoImpl;

import com.mycompany.dao.DaoFoodTruck;
import com.mycompany.dto.DtoFoodTruck;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adriel
 */
public class DaoImplFoodTruck implements DaoFoodTruck{
    
    private List<DtoFoodTruck> foodTruckDB = new ArrayList<>();
    
    //THIS IS JUST FOR TESTING
    public DaoImplFoodTruck(){
        DtoFoodTruck foodTruck1 = new DtoFoodTruck(1L);foodTruck1.setId(1L);
        DtoFoodTruck foodTruck2 = new DtoFoodTruck(2L);foodTruck2.setId(2L);
        foodTruckDB.add(foodTruck1);
        foodTruckDB.add(foodTruck2);
    }
    
    @Override
    public void create(DtoFoodTruck entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modify(DtoFoodTruck entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(DtoFoodTruck entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtoFoodTruck findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DtoFoodTruck> findAll() {
        return foodTruckDB;
    }

    @Override
    public List<DtoFoodTruck> findAllFrom(Long idInspector) {
        List<DtoFoodTruck> listForInspector = new ArrayList<>();
        for(DtoFoodTruck dtoFoodTruck: foodTruckDB){
            if(dtoFoodTruck.getId() == idInspector){
                listForInspector.add(dtoFoodTruck);
            }
        }
        return listForInspector;
    }
    
}
