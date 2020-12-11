/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daoImpl;

import com.mycompany.dao.DaoForm;
import com.mycompany.dbConnection.FactoryDB;
import com.mycompany.dbConnection.GenericDB;
import com.mycompany.dbConnection.TypeDB;
import com.mycompany.dto.DtoForm;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author adriel
 */
public class DaoImplForm implements DaoForm {
    
    private GenericDB db = FactoryDB.getDataBase(TypeDB.MYSQL);
    private DtoForm dtoForm = new DtoForm();
    
    @Override
    public void create(DtoForm entity) {
        try{
            db.connect();
            PreparedStatement pst = db.getConnection().prepareStatement("INSERT INTO TEST_FORM(ID_INSPECTOR, ID_FOODTRUCK, INSPECTION_TIME, CLEANING_STATUS, DESCRIPTION) VALUES (?,?,?,?,?)");
            pst.setLong(1, entity.getIdInspector());
            pst.setLong(2, entity.getIdTruck());
            pst.setTimestamp(3, entity.getInspectionTime());
            pst.setBoolean(4, entity.getCleaningStatus());
            pst.setString(5, entity.getDescription());
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
    public void modify(DtoForm entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(DtoForm entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtoForm findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DtoForm> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtoForm findLast() {
        
        try{
            db.connect();
            PreparedStatement pst = db.getConnection().prepareStatement("SELECT * FROM TEST_FORM ORDER BY ID_FORM DESC LIMIT 1");
            ResultSet rs = pst.executeQuery();
            rs.next();
            dtoForm.setId(rs.getLong("id_form"));
            dtoForm.setIdInspector(rs.getLong("id_inspector"));
            dtoForm.setIdTruck(rs.getLong("id_foodtruck"));
            dtoForm.setInspectionTime(rs.getTimestamp("inspection_time"));
            dtoForm.setCleaningStatus(rs.getBoolean("cleaning_status"));
            dtoForm.setDescription(rs.getString("description"));
            rs.close();
            pst.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            db.close();
            return dtoForm;
        }
    }
    
}
