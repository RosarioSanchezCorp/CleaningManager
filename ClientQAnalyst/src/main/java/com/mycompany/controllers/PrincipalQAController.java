/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import com.mycompany.FileHandler;
import com.mycompany.apiService.Requester;
import com.mycompany.enums.Method;
import com.mycompany.enums.Service;
import com.mycompany.supports.Registry;
import java.io.File;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alex_rosario
 */
public class PrincipalQAController implements Initializable {

    
    private Requester requester = new Requester();
    private ObservableList<Registry> observableList = FXCollections.observableArrayList();
    private List<Registry> registryList = new ArrayList<>();
    private Stage stage;
    
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
    
    @FXML private void export(ActionEvent event){
        FileChooser fc = new FileChooser();
        fc.setInitialFileName("Registries.csv");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("csv", "*.csv"));
        File file = fc.showSaveDialog(stage);
        System.out.println(file.getAbsolutePath());
        this.registryList = requester.getObjectList(Service.QANALYST, Method.GET_REGISTRY_LIST);
        FileHandler.saveCSV(file.getAbsolutePath(), this.registryList);      
    }

    public void setStage(Stage stage) {
        this.stage = stage;
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
                updateTable2();      
            }
        }
        
        public void updateTable2(){
            Registry r = (Registry) requester.getObject(Service.QANALYST, Method.GET_LAST_REGISTRY);
            dataTable.getItems().add(r);
        }
        
    }
    
}
