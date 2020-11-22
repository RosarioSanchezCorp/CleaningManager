/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbConnection;

/**
 *
 * @author alex_rosario
 */
public class FactoryDB {
    
    public static GenericDB getDataBase(TypeDB dataBase){
        
        switch(dataBase){
            case MYSQL:
                return new MysqlDB();
            
            default:
                return null;
        }
    }
}
