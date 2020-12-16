/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.clientServices.Requester;
import com.mycompany.enums.Method;
import com.mycompany.enums.Service;
import com.mycompany.supports.Registry;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author alex_rosario
 */
public class PrincipalQAController implements Initializable {

    
    private Requester requester = new Requester();
    private ObservableList<Registry> observableList = FXCollections.observableArrayList();
    
    @FXML TableView<Registry> dataTable = new TableView<Registry>();
    @FXML private TableColumn<Registry, Long> id_form= new TableColumn<>("ID_FORM");
    @FXML private TableColumn<Registry, String> inspector= new TableColumn<>("INSPECTOR");
    @FXML private TableColumn<Registry, String> iphone_number= new TableColumn<>("PHONE_NUMBER");
    @FXML private TableColumn<Registry, Timestamp> inspection_time= new TableColumn<>("INSPECTION_TIME");
    @FXML private TableColumn<Registry, Long> foodtruck= new TableColumn<>("FOODTRUCK");
    @FXML private TableColumn<Registry, Boolean> cleaning_status= new TableColumn<>("CLEANING_STATUS");
    @FXML private TableColumn<Registry, String> operator= new TableColumn<>("OPERATOR");
    @FXML private TableColumn<Registry, String> ophone_number= new TableColumn<>("PHONE_NUMBER");
    @FXML private TableColumn<Registry, String> description= new TableColumn<>("DESCRIPTION");
    
    
    private void loadTable(){
        observableList.addAll(requester.getObjectList(Service.QANALYST, Method.GET_REGISTRY_LIST));
        dataTable.getItems().addAll(observableList);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        id_form.setCellValueFactory(new PropertyValueFactory<Registry, Long>("id"));
        inspector.setCellValueFactory(new PropertyValueFactory<Registry, String>("inspectorName"));
        iphone_number.setCellValueFactory(new PropertyValueFactory<Registry, String>("inspectorPhoneNumber"));
        inspection_time.setCellValueFactory(new PropertyValueFactory<Registry, Timestamp>("inspectionTime"));
        foodtruck.setCellValueFactory(new PropertyValueFactory<Registry, Long>("idFoodTruck"));
        cleaning_status.setCellValueFactory(new PropertyValueFactory<Registry, Boolean>("cleaningStatus"));
        operator.setCellValueFactory(new PropertyValueFactory<Registry, String>("operatorName"));
        ophone_number.setCellValueFactory(new PropertyValueFactory<Registry, String>("operatorPhoneNumber"));
        description.setCellValueFactory(new PropertyValueFactory<Registry, String>("description"));
        loadTable();
        Thread t = new Thread(new Render());
        t.start(); 
 
    } 
    
    class Render implements Runnable{

        @Override
        public void run() {
            while(true){
                try{
                    updateTable();
                    Thread.sleep(10000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        
        public void updateTable(){
            observableList.clear();
            observableList.addAll(requester.getObjectList(Service.QANALYST, Method.GET_REGISTRY_LIST));
            dataTable.getItems().clear();
            dataTable.getItems().addAll(observableList);
        }
        
    }
    
}
