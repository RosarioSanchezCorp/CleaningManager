/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entites;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author alex_rosario
 */
public class Response <O> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private O object;
    private List<O> objectList;
    private String type;

    public Response(O object, String type) {
        this.object = object;
        this.type = type;
    }

    public Response(List<O> objectList, String type) {
        this.objectList = objectList;
        this.type = type;
    }

    public O getObject() {
        return object;
    }

    public List<O> getObjectList() {
        return objectList;
    }

    public String getType() {
        return type;
    }
    
}
