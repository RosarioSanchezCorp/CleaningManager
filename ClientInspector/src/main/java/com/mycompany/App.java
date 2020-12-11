package com.mycompany;

import com.mycompany.clientServices.Requester;
import com.mycompany.entities.Appliance;
import com.mycompany.entities.FoodTruck;
import com.mycompany.entities.Form;
import com.mycompany.entities.Inspector;
import com.mycompany.enums.Method;
import com.mycompany.enums.Service;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        Requester requester = Requester.getRequester();
        requester.start();
        /*List<Inspector> inspectorList = requester.getObjectList(Service.INSPECTOR, Method.GET_INSPECTOR_LIST);
        List<FoodTruck> foodTruckList = requester.getObjectList(Service.INSPECTOR, Method.GET_FOODTRUCK_LIST);
        LocalDate time = LocalDate.now();
        Date inspectionTime = java.sql.Date.valueOf(time);
        List<Appliance> applianceList = requester.getObjectList(Service.INSPECTOR, Method.GET_APPLIANCE_LIST);
        applianceList.get(0).setCleaningStatus(true);
        applianceList.get(1).setCleaningStatus(false);
        applianceList.get(2).setCleaningStatus(true);
        Boolean cleaningStatus = false;
        String description = "The toaster was so dirty";
        
        for(Inspector i: inspectorList){
            System.out.println(i.getId()+" "+i.getName()+" "+i.getLastName()+" "+i.getPhoneNumber());
        }
        for(FoodTruck f: foodTruckList){
            System.out.println(f.getId());
        }
        for(Appliance a: applianceList){
            System.out.println(a.getId()+" "+a.getName()+" "+a.getCleaningStatus());
        }
        Form form = new Form(inspectorList.get(0), foodTruckList.get(0), inspectionTime, applianceList, cleaningStatus, description);
        requester.sendObject(Service.INSPECTOR, Method.CREATE_FORM, form);
        */
        
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
        applianceList.get(1).setCleaningStatus(false);
        applianceList.get(2).setCleaningStatus(true);
        applianceList.get(3).setCleaningStatus(true);
        applianceList.get(4).setCleaningStatus(true);
        applianceList.get(5).setCleaningStatus(true);
        applianceList.get(6).setCleaningStatus(true);
        Timestamp inspectionTime = new Timestamp(System.currentTimeMillis());
        Boolean cleaningStatus = false;
        String description = "The stove was derty";
        Form form = new Form(inspectorList.get(0), foodTruckList.get(0), inspectionTime, applianceList, cleaningStatus, description);
        requester.sendObject(Service.INSPECTOR, Method.CREATE_FORM, form);
        
    }
}
