/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alex_rosario
 */
public class MysqlDB extends GenericDB {
    
    protected Connection connection;
    private final String driverJDBC = "com.mysql.jdbc.Driver";
    private final String urlDB = "jdbc:mysql://localhost:3306/test?useSSL=false";
    private final String user = "root";
    private final String password = "";
    
    @Override
    public void connect() {
        try {
            Class.forName(driverJDBC);
            connection = DriverManager.getConnection(urlDB, user, password);
            
            } catch (Exception ex) {
                ex.printStackTrace();
            } 
    }

    @Override
    public void close() {
        try{
            if(connection != null){
                if(!connection.isClosed()){
                    connection.close();
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
    
}
