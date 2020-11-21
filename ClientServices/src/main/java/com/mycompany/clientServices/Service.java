/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientServices;

import com.mycompany.entites.*;

import java.util.List;

/**
 *
 * @author alex_rosario
 */
public class Service <O> {
    
    private O object;
    private List<O> objectList;
    
    public static<O> void sendObject(String service, String method, O object){
        
        Request request = new Request(service, method, object);
        
    }
    
}
