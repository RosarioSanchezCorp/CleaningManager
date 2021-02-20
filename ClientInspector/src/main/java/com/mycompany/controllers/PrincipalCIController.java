/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.apiService.Requester;
import com.mycompany.entities.Appliance;
import com.mycompany.entities.FoodTruck;
import com.mycompany.entities.Form;
import com.mycompany.entities.Inspector;
import com.mycompany.enums.Method;
import com.mycompany.enums.Service;
import com.mycompany.supports.ApplianceRegistry;
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
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

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
    @FXML private TextArea taDescription = new TextArea();
    
    @FXML private TableView<ApplianceRegistry> applianceTable = new TableView<ApplianceRegistry>();
    @FXML private TableColumn<ApplianceRegistry, String> appliance_name = new TableColumn<>("APPLIANCES");
    @FXML private TableColumn<ApplianceRegistry, CheckBox> appliance_cb = new TableColumn<>("CLEAN");
    
    ObservableList obInspectorList = FXCollections.observableArrayList();
    ObservableList obFoodtruckList = FXCollections.observableArrayList();
    ObservableList<ApplianceRegistry> obApplianceList = FXCollections.observableArrayList();
    
    List<Inspector> inspectorList = new ArrayList<>();
    List<FoodTruck> foodtruckList = new ArrayList<>();
    List<Appliance> applianceList = new ArrayList<>();
    
    private void loadInspectors(){
        obInspectorList.removeAll(obInspectorList);
        for(Inspector i: inspectorList){
            obInspectorList.add(i.getId());
        }
        inspectors.getItems().clear();
        inspectors.getItems().addAll(obInspectorList); 
    }
    
    private void loadFoodtrucks(){
        obFoodtruckList.removeAll(obFoodtruckList);
        for(FoodTruck f: foodtruckList){
            obFoodtruckList.add(f.getId());
        }
        foodtrucks.getItems().clear();
        foodtrucks.getItems().addAll(obFoodtruckList);
    }
    
    private void loadAppliances(){
        for(Appliance a: applianceList){
            ApplianceRegistry ar = new ApplianceRegistry(a.getName());
            obApplianceList.add(ar);
        }
        applianceTable.getItems().addAll(obApplianceList);
    }
    
    private void clearAll(){
        loadInspectors();
        loadFoodtrucks();
        for(ApplianceRegistry ar: obApplianceList){
            ar.getCb().setSelected(false);
        }
        taDescription.setText("");
    }
    
    @FXML private void send(ActionEvent event){
        
        Inspector inspectorSelected = (Inspector) requester.getObject(Service.INSPECTOR, Method.GET_INSPECTOR, inspectors.getValue());
        FoodTruck foodtruckSelected = (FoodTruck) requester.getObject(Service.INSPECTOR, Method.GET_FOODTRUCK, foodtrucks.getValue());
        
        boolean cleaningStatus = true;
        
        for(int i = 0; i < applianceList.size(); i++){
            if(obApplianceList.get(i).getCb().isSelected()){
                applianceList.get(i).setCleaningStatus(true);
            }
            else{
                applianceList.get(i).setCleaningStatus(true);
                cleaningStatus = false;
            }
        }
        String description = taDescription.getText();
        Timestamp inspectionTime = new Timestamp(System.currentTimeMillis());
        Form form = new Form(inspectorSelected, foodtruckSelected, inspectionTime, applianceList, cleaningStatus, description);
        requester.sendObject(Service.INSPECTOR, Method.CREATE_FORM, form);   
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFORMATION");
        alert.setContentText("The form has been sent succesfully");
        alert.show();
        clearAll();  
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inspectorList = requester.getObjectList(Service.INSPECTOR, Method.GET_INSPECTOR_LIST);
        foodtruckList = requester.getObjectList(Service.INSPECTOR, Method.GET_FOODTRUCK_LIST);
        applianceList = requester.getObjectList(Service.INSPECTOR, Method.GET_APPLIANCE_LIST);
        appliance_name.setCellValueFactory(new PropertyValueFactory<ApplianceRegistry, String>("name"));
        appliance_cb.setCellValueFactory(new PropertyValueFactory<ApplianceRegistry, CheckBox>("cb"));
        loadInspectors();
        loadFoodtrucks();
        loadAppliances();
    }    
    
}
