package com.mycompany;

import com.mycompany.clientServices.Requester;
import com.mycompany.enums.Method;
import com.mycompany.enums.Service;
import com.mycompany.supports.Registry;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Requester requester = new Requester();
        List<Registry> registryList = requester.getObjectList(Service.QANALYST, Method.GET_REGISTRY_LIST);
        for(Registry r: registryList){
            System.out.println(r.getId()+" "+r.getInspectorName()+" "+r.getInspectorPhoneNumber()+" "+r.getInspectionTime()+" "+r.getIdFoodTruck()+
                    " "+r.getCleaningStatus()+" "+r.getOperatorName()+" "+r.getOperatorPhoneNumber()+" "+r.getDescription());
        }
    }
}
