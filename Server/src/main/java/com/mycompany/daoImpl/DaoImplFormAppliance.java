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
import com.mycompany.supports.Registry;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        List<Registry> registryList = new ArrayList<>();
        try{
            db.connect();
            PreparedStatement pst = db.getConnection().prepareStatement("SELECT TEST_FORM.ID_FORM, TEST_INSPECTOR.NAME AS INSPECTOR, TEST_INSPECTOR.PHONE_NUMBER "
                    + "AS INSPECTOR_PHONE_NUMBER,TEST_FORM.INSPECTION_TIME,TEST_FORM.ID_FOODTRUCK, TEST_FORM.CLEANING_STATUS, TEST_OPERATOR.NAME AS OPERATOR, "
                    + "TEST_OPERATOR.PHONE_NUMBER AS OPERATOR_PHONE_NUMBER,TEST_FORM.DESCRIPTION FROM TEST_FORM INNER JOIN TEST_INSPECTOR ON "
                    + "TEST_INSPECTOR.ID_INSPECTOR = TEST_FORM.ID_INSPECTOR INNER JOIN TEST_OPERATOR ON TEST_OPERATOR.ID_FOODTRUCK = TEST_FORM.ID_FOODTRUCK "
                    + "ORDER BY ID_FORM;");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Registry r = new Registry();
                r.setId(rs.getLong("id_form"));
                r.setInspectorName(rs.getString("inspector"));
                r.setInspectorPhoneNumber(rs.getString("inspector_phone_number"));
                r.setInspectionTime(rs.getTimestamp("inspection_time"));
                r.setIdFoodTruck(rs.getLong("id_foodtruck"));
                r.setCleaningStatus(rs.getBoolean("cleaning_status"));
                r.setOperatorName(rs.getString("operator"));
                r.setOperatorPhoneNumber(rs.getString("operator_phone_number"));
                r.setDescription(rs.getString("description"));
                registryList.add(r);               
            }
            rs.close();
            pst.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            db.close();
            return registryList;
        }
    }

    @Override
    public Registry findLast() {
        Registry r = new Registry();
        try{
            db.connect();
            PreparedStatement pst = db.getConnection().prepareStatement("SELECT TEST_FORM.ID_FORM, TEST_INSPECTOR.NAME AS INSPECTOR, TEST_INSPECTOR.PHONE_NUMBER "
                    + "AS INSPECTOR_PHONE_NUMBER,TEST_FORM.INSPECTION_TIME,TEST_FORM.ID_FOODTRUCK, TEST_FORM.CLEANING_STATUS, TEST_OPERATOR.NAME AS OPERATOR, "
                    + "TEST_OPERATOR.PHONE_NUMBER AS OPERATOR_PHONE_NUMBER,TEST_FORM.DESCRIPTION FROM TEST_FORM INNER JOIN TEST_INSPECTOR ON "
                    + "TEST_INSPECTOR.ID_INSPECTOR = TEST_FORM.ID_INSPECTOR INNER JOIN TEST_OPERATOR ON TEST_OPERATOR.ID_FOODTRUCK = TEST_FORM.ID_FOODTRUCK "
                    + "ORDER BY ID_FORM DESC LIMIT 1;");
            ResultSet rs = pst.executeQuery();
            rs.next();
            r.setId(rs.getLong("id_form"));
            r.setInspectorName(rs.getString("inspector"));
            r.setInspectorPhoneNumber(rs.getString("inspector_phone_number"));
            r.setInspectionTime(rs.getTimestamp("inspection_time"));
            r.setIdFoodTruck(rs.getLong("id_foodtruck"));
            r.setCleaningStatus(rs.getBoolean("cleaning_status"));
            r.setOperatorName(rs.getString("operator"));
            r.setOperatorPhoneNumber(rs.getString("operator_phone_number"));
            r.setDescription(rs.getString("description"));
            rs.close();
            pst.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            db.close();
            return r;
        }
    }
    
}
