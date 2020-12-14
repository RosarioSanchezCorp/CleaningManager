/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.clientServices.Requester;
import com.mycompany.entities.Appliance;
import com.mycompany.entities.FoodTruck;
import com.mycompany.entities.Form;
import com.mycompany.entities.Inspector;
import com.mycompany.enums.Method;
import com.mycompany.enums.Service;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author alex_rosario
 */
public class PrincipalCIController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Requester requester = new Requester();
    
    @FXML private ChoiceBox<Long> inspectors = new ChoiceBox();
    @FXML private ChoiceBox<Long> foodtrucks = new ChoiceBox();
    @FXML private CheckBox cbAppliance1 = new CheckBox();
    @FXML private CheckBox cbAppliance2 = new CheckBox();
    @FXML private CheckBox cbAppliance3 = new CheckBox();
    @FXML private CheckBox cbAppliance4 = new CheckBox();
    @FXML private CheckBox cbAppliance5 = new CheckBox();
    @FXML private CheckBox cbAppliance6 = new CheckBox();
    @FXML private CheckBox cbAppliance7 = new CheckBox();
    @FXML private TextArea taDescription = new TextArea();
    
    ObservableList obInspectorList = FXCollections.observableArrayList();
    ObservableList obFoodtruckList = FXCollections.observableArrayList();
    
    List<Inspector> inspectorList = new ArrayList<>();
    List<FoodTruck> foodtruckList = new ArrayList<>();
    List<Appliance> applianceList = new ArrayList<>();
    
    private void loadInspectors(){
        obInspectorList.removeAll(obInspectorList);
        for(Inspector i: inspectorList){
            obInspectorList.add(i.getId());
        }
        inspectors.getItems().addAll(obInspectorList); 
    }
    
    private void loadFoodtrucks(){
        obFoodtruckList.removeAll(obFoodtruckList);
        for(FoodTruck f: foodtruckList){
            obFoodtruckList.add(f.getId());
        }
        foodtrucks.getItems().addAll(obFoodtruckList);
    }
    
    @FXML private void send(ActionEvent event){
        
        Inspector inspectorSelected = (Inspector) requester.getObject(Service.INSPECTOR, Method.GET_INSPECTOR, inspectors.getValue());
        FoodTruck foodtruckSelected = (FoodTruck) requester.getObject(Service.INSPECTOR, Method.GET_FOODTRUCK, foodtrucks.getValue());
        
        boolean cleaningStatus = true;
        if(cbAppliance1.isSelected()){
            applianceList.get(0).setCleaningStatus(true);
        }
        else{
            applianceList.get(0).setCleaningStatus(false);
            cleaningStatus = false;
        }
        if(cbAppliance2.isSelected()){
            applianceList.get(1).setCleaningStatus(true);
        }
        else{
            applianceList.get(1).setCleaningStatus(false);
            cleaningStatus = false;
        }
        if(cbAppliance3.isSelected()){
            applianceList.get(2).setCleaningStatus(true);
        }
        else{
            applianceList.get(2).setCleaningStatus(false);
            cleaningStatus = false;
        }
        if(cbAppliance4.isSelected()){
            applianceList.get(3).setCleaningStatus(true);
        }
        else{
            applianceList.get(3).setCleaningStatus(false);
            cleaningStatus = false;
        }
        if(cbAppliance5.isSelected()){
            applianceList.get(4).setCleaningStatus(true);
        }
        else{
            applianceList.get(4).setCleaningStatus(false);
            cleaningStatus = false;
        }
        if(cbAppliance6.isSelected()){
            applianceList.get(5).setCleaningStatus(true);
        }
        else{
            applianceList.get(5).setCleaningStatus(false);
            cleaningStatus = false;
        }
        if(cbAppliance7.isSelected()){
            applianceList.get(6).setCleaningStatus(true);
        }
        else{
            applianceList.get(6).setCleaningStatus(false);
            cleaningStatus = false;
        }
        String description = taDescription.getText();
        Timestamp inspectionTime = new Timestamp(System.currentTimeMillis());
        Form form = new Form(inspectorSelected, foodtruckSelected, inspectionTime, applianceList, cleaningStatus, description);
        requester.sendObject(Service.INSPECTOR, Method.CREATE_FORM, form);   
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inspectorList = requester.getObjectList(Service.INSPECTOR, Method.GET_INSPECTOR_LIST);
        foodtruckList = requester.getObjectList(Service.INSPECTOR, Method.GET_FOODTRUCK_LIST);
        applianceList = requester.getObjectList(Service.INSPECTOR, Method.GET_APPLIANCE_LIST);
        loadInspectors();
        loadFoodtrucks();
    }    
    
}
