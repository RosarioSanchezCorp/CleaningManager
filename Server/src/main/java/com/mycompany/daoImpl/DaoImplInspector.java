/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daoImpl;

import com.mycompany.dao.DaoInspector;
import com.mycompany.dbConnection.FactoryDB;
import com.mycompany.dbConnection.GenericDB;
import com.mycompany.dbConnection.TypeDB;
import com.mycompany.dto.DtoInspector;
import com.mycompany.entities.Inspector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adriel
 */
public class DaoImplInspector implements DaoInspector{
    
    private GenericDB db = FactoryDB.getDataBase(TypeDB.MYSQL);
    private List<DtoInspector> inspectorList = new ArrayList<>();
    
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
        DtoInspector dtoInspector = new DtoInspector();
        try{
            db.connect();
            PreparedStatement pst = db.getConnection().prepareStatement("SELECT * FROM TEST_INSPECTOR WHERE ID_INSPECTOR = ?");
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            dtoInspector.setId(rs.getLong("id_inspector"));
            dtoInspector.setName(rs.getString("name"));
            dtoInspector.setLastName(rs.getString("lastname"));
            dtoInspector.setPhoneNumber(rs.getString("phone_number"));
            rs.close();
            pst.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            db.close();
            return dtoInspector;
        }
    }

    @Override
    public List<DtoInspector> findAll() {
        this.inspectorList.clear();
        try{
            db.connect();
            PreparedStatement pst = db.getConnection().prepareStatement("SELECT * FROM TEST_INSPECTOR");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                DtoInspector i = new DtoInspector();
                i.setId(rs.getLong("id_inspector"));
                i.setName(rs.getString("name"));
                i.setLastName(rs.getString("lastname"));
                i.setPhoneNumber(rs.getString("phone_number"));
                inspectorList.add(i);
            }
            rs.close();
            pst.close();       
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            db.close();
            return inspectorList;
        }
        
    }
    
}
