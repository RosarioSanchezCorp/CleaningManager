/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientServices;

import com.mycompany.entities.Request;
import com.mycompany.entities.Response;
import com.mycompany.enums.Method;
import com.mycompany.enums.Service;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author alex_rosario
 */
public class Requester<O>{
    
    private O object;
    private List<O> objectList;
    private final String ip = "10.0.0.6";
    
    
    public void sendObject(Service service, Method method, O object){
        
        try{
            Socket s = new Socket(ip, 3333); 
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            Request request = new Request(service, method, object);
            out.writeObject(request);
            Response response = (Response) in.readObject();
            in.close();
            out.close();
            s.close();    
        }
        catch(Exception e){
            e.printStackTrace();
        }     
    }
    
    public O getObject(Service service, Method method, Long id){
        
        try{
            Socket s = new Socket(ip, 3333); 
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            Request request = new Request(service, method, id);
            out.writeObject(request);
            Response response = (Response) in.readObject();
            object = (O) response.getObject();
            in.close();
            out.close();
            s.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            return object;
        }
    }
    
    public List<O> getObjectList(Service service, Method method){
        
        try{
            Socket s = new Socket(ip, 3333); 
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            Request request = new Request(service, method);
            out.writeObject(request);
            Response response = (Response) in.readObject();
            objectList = response.getObjectList();
            in.close();
            out.close();
            s.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        finally{
            return objectList;
        }    
    }
}
