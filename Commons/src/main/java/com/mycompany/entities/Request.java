/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import com.mycompany.enums.Method;
import com.mycompany.enums.Service;
import java.io.Serializable;

/**
 *
 * @author alex_rosario
 */
public class Request <O> implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Service service;
    private Method method;
    private Long id;
    private O object;

    public Request(Service service, Method method, O object) {
        this.service = service;
        this.method = method;
        this.object = object;
    }

    public Request(Service service, Method method, Long id) {
        this.service = service;
        this.method = method;
        this.id = id;
    }

    public Request(Service service, Method method) {
        this.service = service;
        this.method = method;
    }

    public Service getService() {
        return service;
    }

    public Method getMethod() {
        return method;
    }

    public Long getId() {
        return id;
    }

    public O getObject() {
        return object;
    }
    
    
    
}
