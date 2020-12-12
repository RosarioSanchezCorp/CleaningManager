package com.mycompany;

import com.mycompany.clientServices.Requester;
import com.mycompany.entities.Appliance;
import com.mycompany.entities.FoodTruck;
import com.mycompany.entities.Form;
import com.mycompany.entities.Inspector;
import com.mycompany.enums.Method;
import com.mycompany.enums.Service;
import java.sql.Timestamp;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main( String[] args ){
        
        
        /*Requester requester = new Requester();
        
        List<Appliance> applianceList = requester.getObjectList(Service.INSPECTOR, Method.GET_APPLIANCE_LIST);
        for(Appliance a: applianceList){
            System.out.println(a.getId()+" "+a.getName());
        }
        
        List<FoodTruck> foodTruckList = requester.getObjectList(Service.INSPECTOR, Method.GET_FOODTRUCK_LIST);
        for(FoodTruck f: foodTruckList){
            System.out.println(f.getId());
        }
        
        List<Inspector> inspectorList = requester.getObjectList(Service.INSPECTOR, Method.GET_INSPECTOR_LIST);
        for(Inspector i: inspectorList){
            System.out.println(i.getId()+" "+i.getName()+" "+i.getLastName()+" "+i.getPhoneNumber());
            System.out.println("List of foodtrucks:");
            for(FoodTruck ft: i.getTruckList()){
                System.out.println("Foodtruck: "+ft.getId());
            }
        }
        
        applianceList.get(0).setCleaningStatus(true);
        applianceList.get(1).setCleaningStatus(true);
        applianceList.get(2).setCleaningStatus(true);
        applianceList.get(3).setCleaningStatus(false);
        applianceList.get(4).setCleaningStatus(true);
        applianceList.get(5).setCleaningStatus(true);
        applianceList.get(6).setCleaningStatus(true);
        Timestamp inspectionTime = new Timestamp(System.currentTimeMillis());
        Boolean cleaningStatus = false;
        String description = "The oven was not very clean";
        Form form = new Form(inspectorList.get(0), foodTruckList.get(0), inspectionTime, applianceList, cleaningStatus, description);
        requester.sendObject(Service.INSPECTOR, Method.CREATE_FORM, form);*/
        launch(args);
        
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLprincipalCI.fxml"));
        Scene scene = new Scene(root,400,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Inpector Form");
        primaryStage.show();
    }

    
}
