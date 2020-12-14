/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.entities.Form;
import com.mycompany.supports.Request;
import com.mycompany.supports.Response;
import com.mycompany.enums.Method;
import com.mycompany.enums.ResponseType;
import com.mycompany.service.ServiceInspector;
import com.mycompany.service.ServiceQAnalyst;
import com.mycompany.serviceImpl.ServiceImplInspector;
import com.mycompany.serviceImpl.ServiceImplQAnalyst;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author alex_rosario
 */
public class ClientHandler extends Thread {
    
    private final ObjectInputStream in; 
    private final ObjectOutputStream out; 
    private final Socket s; 
    private ServiceQAnalyst serviceQAnalyst;
    private ServiceInspector serviceInspector;

  
    public ClientHandler(Socket s, ObjectInputStream in, ObjectOutputStream out) {
        this.s = s;
        this.in = in;
        this.out = out;
        this.serviceQAnalyst = new ServiceImplQAnalyst();
        this.serviceInspector = new ServiceImplInspector();     
    }
    
    @Override
    public void run(){
        try {
            Request request = (Request) in.readObject();
            switch(request.getService()){
                case QANALYST:
                    if(request.getMethod() == Method.GET_REGISTRY_LIST){                       
                        Response response = new Response(serviceQAnalyst.getRegistryList(), ResponseType.LIST);
                        this.out.writeObject(response);
                        this.out.close();
                        this.s.close();                           
                    }
                    else if(request.getMethod() == Method.GET_LAST_REGISTRY){                      
                        Response response = new Response(serviceQAnalyst.getLastRegistry(), ResponseType.OBJECT);
                        this.out.writeObject(response);
                        this.out.close();
                        this.s.close();                                          
                    }
                    break;

                case INSPECTOR:
                    if(request.getMethod() == Method.CREATE_FORM){                       
                        serviceInspector.createForm((Form) request.getObject());
                        Response response = new Response(ResponseType.CONFIRMATION);
                        this.out.writeObject(response);
                        this.out.close();
                        s.close();    
                        System.out.println("The service was consumed");
                    }
                    else if(request.getMethod() == Method.GET_APPLIANCE_LIST){                       
                        Response response = new Response(serviceInspector.getApplianceList(), ResponseType.LIST);
                        this.out.writeObject(response);
                        this.out.close();
                        this.s.close();                                            
                    }
                    else if(request.getMethod() == Method.GET_INSPECTOR_LIST){                      
                        Response response = new Response(serviceInspector.getInspectorList(), ResponseType.LIST);
                        this.out.writeObject(response);
                        this.out.close();
                        this.s.close();                                             
                    }
                    else if(request.getMethod() == Method.GET_FOODTRUCK_LIST){                                                    
                        Response response = new Response(serviceInspector.getFoodTruckList(), ResponseType.LIST);
                        this.out.writeObject(response);
                        this.out.close();
                        this.s.close();                                            
                    }
                    else if(request.getMethod() == Method.GET_INSPECTOR){                      
                        Response response = new Response(serviceInspector.getInspector(request.getId()), ResponseType.OBJECT);
                        this.out.writeObject(response);
                        this.out.close();
                        this.s.close();                                             
                    }
                    else if(request.getMethod() == Method.GET_FOODTRUCK){
                        Response response = new Response(serviceInspector.getFoodtruck(request.getId()), ResponseType.OBJECT);
                        this.out.writeObject(response);
                        this.out.close();
                        this.s.close(); 
                    }
                    break;

                default:
                    System.out.println(request.getService()+": this service does not exist");
            }  
        } 
        catch (Exception e) {
            e.printStackTrace();
        }    
    }
}
