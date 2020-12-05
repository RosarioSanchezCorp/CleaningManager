/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientServices;

import com.mycompany.entities.Response;
import com.mycompany.entities.Request;
import com.mycompany.enums.Method;
import com.mycompany.enums.Service;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.List;

/**
 *
 * @author alex_rosario
 */
public class Requester <O> extends Thread{
    
    private O object;
    private List<O> objectList;
    private static Requester requester;
    
    
    //APPLYING THE SINGLETON PATTERN
    private Requester(){}
    public static Requester getRequester(){
        
        if(requester == null){
            requester = new Requester();
        }  
        return requester;
    }
    
    
    @Override
    public void run(){
        try{
            System.out.println("The client is runnig");
            ServerSocket server = new ServerSocket(44447);
            while(true){
                Socket socket = server.accept();
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Response response = (Response) in.readObject();
                
                switch(response.getType()){
                    case OBJECT:
                        this.object = (O) response.getObject();
                        break;
                    case LIST:
                        this.objectList = response.getObjectList();
                        break;
                }
                in.close();
                socket.close();
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public <O> void sendObject(Service service, Method method, O object){
        
        Request request = new Request(service, method, object);
        try {
            
            Socket socket = new Socket("10.0.0.6" , 44444);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(request);
            out.close();
            socket.close();
            System.out.println("The object was sent");
                
        }
        catch (Exception ex) {
            System.out.println("The object was not sent");
        }       
    }
    
    public O getObject(Service service, Method method, Long id){
        
        InetAddress inetAddress = null;
        
        try{
            inetAddress = InetAddress. getLocalHost();
        }
        catch(Exception e){
            
        }
        
        Request request = new Request(service, method, id, inetAddress.getHostAddress());
        
        try {
            
            Socket socket = new Socket("10.0.0.6" , 44444);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(request);
            out.close();
            socket.close();
            System.out.println("The object was sent");
                
        }
        catch (Exception ex) {
            System.out.println("The object was not sent");
        }
        
        //THIST PART IS JUST TO GIVE A LITTLE BIT OF TIME TO THE SERVER TO SEND THE OBJECT
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        return this.object;
    }
    
    public List<O> getObjectList(Service service, Method method){
        
        InetAddress inetAddress = null;
        
        try{
            inetAddress = InetAddress. getLocalHost();
        }
        catch(Exception e){
            
        }
        
        Request request = new Request(service, method, inetAddress.getHostAddress());
        try {
            
            Socket socket = new Socket("10.0.0.6" , 44444);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(request);
            out.close();
            socket.close();
            System.out.println("The object was sent");
                
        }
        catch (Exception ex) {
            System.out.println("The object was not sent");
        }
        
        //THIST PART IS JUST TO GIVE A LITTLE BIT OF TIME TO THE SERVER TO SEND THE OBJECT
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        return this.objectList;
    }
    
}
