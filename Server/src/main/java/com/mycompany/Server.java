/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;
import com.mycompany.entities.Form;
import com.mycompany.entities.Request;
import com.mycompany.entities.Response;
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
            while(true){
                Socket socket = server.accept();
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                
                switch(request.getService()){
                    case "serviceQAnalyst":
                        if(request.getMethod().equalsIgnoreCase("getRegistryList")){
                            try{
                                Socket socketForClient = new Socket(request.getIp(), 44447);
                                ObjectOutputStream out = new ObjectOutputStream(socketForClient.getOutputStream());
                                Response response = new Response(serviceQAnalyst.getRegistryList(), "list");
                                out.writeObject(response);
                                out.close();
                                socketForClient.close();
                            }
                            catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                        break;
                    
                    case "serviceInspector":
                        if(request.getMethod().equalsIgnoreCase("createForm")){
                            serviceInspector.createForm((Form) request.getObject());
                        }
                        else if(request.getMethod().equalsIgnoreCase("getApplianceList")){
                            try{
                                Socket socketForClient = new Socket(request.getIp(), 44447);
                                ObjectOutputStream out = new ObjectOutputStream(socketForClient.getOutputStream());
                                Response response = new Response(serviceInspector.getApplianceList(), "list");
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
