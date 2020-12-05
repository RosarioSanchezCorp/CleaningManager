/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daoImpl;

import com.mycompany.dao.DaoFormAppliance;
import com.mycompany.dbConnection.FactoryDB;
import com.mycompany.dbConnection.GenericDB;
import com.mycompany.dbConnection.TypeDB;
import com.mycompany.dto.DtoFormAppliance;
import com.mycompany.entities.Registry;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adriel
 */
public class DaoImplFormAppliance implements DaoFormAppliance {
    
    private GenericDB db = FactoryDB.getDataBase(TypeDB.MYSQL);
    private List<DtoFormAppliance> formApplianceList = new ArrayList<>();

    @Override
    public void create(DtoFormAppliance entity) {
        try{
            db.connect();
            PreparedStatement pst = db.getConnection().prepareStatement("INSERT INTO TEST_FORM_APPLIANCE(ID_FORM, ID_APPLIANCE, CLEANING_STATUS) VALUES(?,?,?)");
            pst.setLong(1, entity.getIdForm());
            pst.setLong(2, entity.getIdAppliance());
            pst.setBoolean(3, entity.getCleaningStatus());
            pst.executeUpdate();
            pst.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            db.close();
        }
    }

    @Override
    public void modify(DtoFormAppliance entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(DtoFormAppliance entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtoFormAppliance findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DtoFormAppliance> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Registry> findAllRegistries() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
