/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;
import com.mycompany.entities.Form;
import com.mycompany.entities.Request;
import com.mycompany.entities.Response;
import com.mycompany.enums.Method;
import static com.mycompany.enums.Method.GET_REGISTRY_LIST;
import com.mycompany.enums.ResponseType;
import com.mycompany.service.ServiceInspector;
import com.mycompany.service.ServiceQAnalyst;
import com.mycompany.serviceImpl.ServiceImplInspector;
import com.mycompany.serviceImpl.ServiceImplQAnalyst;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author adriel
 */
public class Server extends Thread {
    
    public void run(){
        
        ServiceQAnalyst serviceQAnalyst = new ServiceImplQAnalyst();
        ServiceInspector serviceInspector = new ServiceImplInspector();
        
        try{
            
            ServerSocket server = new ServerSocket(44444);
            System.out.println("The server is runnig");
            while(true){
                Socket socket = server.accept();
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                
                switch(request.getService()){
                    case QANALYST:
                        if(request.getMethod() == Method.GET_REGISTRY_LIST){
                            try{
                                Socket socketForClient = new Socket(request.getIp(), 44447);
                                ObjectOutputStream out = new ObjectOutputStream(socketForClient.getOutputStream());
                                Response response = new Response(serviceQAnalyst.getRegistryList(), ResponseType.LIST);
                                out.writeObject(response);
                                out.close();
                                socketForClient.close();
                            }
                            catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                        break;
                    
                    case INSPECTOR:
                        if(request.getMethod() == Method.CREATE_FORM){
                            serviceInspector.createForm((Form) request.getObject());
                            System.out.println("The service was consumed succesfully!");
                        }
                        else if(request.getMethod() == Method.GET_APPLIANCE_LIST){
                            try{
                                Socket socketForClient = new Socket(request.getIp(), 44447);
                                ObjectOutputStream out = new ObjectOutputStream(socketForClient.getOutputStream());
                                Response response = new Response(serviceInspector.getApplianceList(), ResponseType.LIST);
                                out.writeObject(response);
                                out.close();
                                socketForClient.close();
                            }
                            catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                        else if(request.getMethod() == Method.GET_INSPECTOR_LIST){
                            try{
                                Socket socketForClient = new Socket(request.getIp(), 44447);
                                ObjectOutputStream out = new ObjectOutputStream(socketForClient.getOutputStream());
                                Response response = new Response(serviceInspector.getInspectorList(), ResponseType.LIST);
                                out.writeObject(response);
                                out.close();
                                socketForClient.close();
                            }
                            catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                        else if(request.getMethod() == Method.GET_FOODTRUCK_LIST){
                            try{
                                Socket socketForClient = new Socket(request.getIp(), 44447);
                                ObjectOutputStream out = new ObjectOutputStream(socketForClient.getOutputStream());
                                Response response = new Response(serviceInspector.getFoodTruckList(), ResponseType.LIST);
                                out.writeObject(response);
                                out.close();
                                socketForClient.close();
                            }
                            catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                        break;
                        
                    default:
                        System.out.println(request.getService()+": this service does not exist");
                }             
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
