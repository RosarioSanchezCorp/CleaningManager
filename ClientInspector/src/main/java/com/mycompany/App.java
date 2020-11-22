package com.mycompany;

import com.mycompany.clientServices.Service;
import com.mycompany.entities.Appliance;
import com.mycompany.entities.FoodTruck;
import com.mycompany.entities.Form;
import com.mycompany.entities.Inspector;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        Service service = new Service();
        service.start();
        List<Inspector> inspectorList = service.getObjectList("serviceInspector", "getInspectorList");
        List<FoodTruck> foodTruckList = service.getObjectList("serviceInspector", "getFoodTruckList");
        LocalDate time = LocalDate.now();
        Date inspectionTime = java.sql.Date.valueOf(time);
        List<Appliance> applianceList = service.getObjectList("serviceInspector", "getApplianceList");
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
        service.sendObject("serviceInspector", "createForm", form);
     
    }
}
