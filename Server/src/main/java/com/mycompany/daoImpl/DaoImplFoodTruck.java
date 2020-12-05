/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daoImpl;

import com.mycompany.dao.DaoFoodTruck;
import com.mycompany.dbConnection.FactoryDB;
import com.mycompany.dbConnection.GenericDB;
import com.mycompany.dbConnection.TypeDB;
import com.mycompany.dto.DtoFoodTruck;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adriel
 */
public class DaoImplFoodTruck implements DaoFoodTruck{
    
    private GenericDB db = FactoryDB.getDataBase(TypeDB.MYSQL);
    private List<DtoFoodTruck> foodtruckList = new ArrayList<>();
    
    
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
        this.foodtruckList.clear();
        try{
            db.connect();
            PreparedStatement pst = db.getConnection().prepareStatement("SELECT * FROM TEST_FOODTRUCK");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                DtoFoodTruck ft = new DtoFoodTruck();
                ft.setId(rs.getLong("id_foodtruck"));
                ft.setIdInspector(rs.getLong("id_inspector"));
                foodtruckList.add(ft);
            }
            rs.close();
            pst.close();
            
        }
        catch(Exception  e){
            e.printStackTrace();
        }
        finally{
            db.close();
            return foodtruckList;
        }  
    }

    @Override
    public List<DtoFoodTruck> findAllFrom(Long idInspector) {
        List<DtoFoodTruck> listForInspector = new ArrayList<>();
        try{
            db.connect();
            PreparedStatement pst = db.getConnection().prepareStatement("SELECT * FROM TEST_FOODTRUCK WHERE ID_INSPECTOR = ?");
            pst.setLong(1, idInspector);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                DtoFoodTruck ft = new DtoFoodTruck();
                ft.setId(rs.getLong("id_foodtruck"));
                ft.setIdInspector(rs.getLong("id_inspector"));
                listForInspector.add(ft);
            }
            rs.close();
            pst.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            db.close();
            return listForInspector;
        }
    }
    
}
