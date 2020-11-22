/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entites;

import java.io.Serializable;

/**
 *
 * @author alex_rosario
 */
public class Request <O> implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private String service;
    private String method;
    private String ip;
    private Long id;
    private O object;

    public Request(String service, String method, O object) {
        this.service = service;
        this.method = method;
        this.object = object;
    }

    public Request(String service, String method, Long id, String ip) {
        this.service = service;
        this.method = method;
        this.ip = ip;
        this.id = id;
    }

    public Request(String service, String method, String ip) {
        this.service = service;
        this.method = method;
        this.ip = ip;
    }

    public String getService() {
        return service;
    }

    public String getMethod() {
        return method;
    }

    public String getIp() {
        return ip;
    }

    public Long getId() {
        return id;
    }

    public O getObject() {
        return object;
    }
    
    
    
}
