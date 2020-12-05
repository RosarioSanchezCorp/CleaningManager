/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daoImpl;

import com.mycompany.dao.DaoAppliance;
import com.mycompany.dbConnection.FactoryDB;
import com.mycompany.dbConnection.GenericDB;
import com.mycompany.dbConnection.TypeDB;
import com.mycompany.dto.DtoAppliance;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adriel
 */
public class DaoImplAppliance implements DaoAppliance{
    
    
    private GenericDB db = FactoryDB.getDataBase(TypeDB.MYSQL);
    private List<DtoAppliance> applianceList = new ArrayList<>();
    
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
        this.applianceList.clear();
        try{
            db.connect();
            PreparedStatement pst = db.getConnection().prepareStatement("SELECT * FROM TEST_APPLIANCE");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                DtoAppliance a = new DtoAppliance();
                a.setId(rs.getLong("id_appliance"));
                a.setName(rs.getString("name"));
                applianceList.add(a);
            }
            rs.close();
            pst.close();          
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
           db.close();
           return this.applianceList; 
        }    
    }  
}
