/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import java.util.List;

/**
 *
 * @author adriel
 * @param <T>
 * @param <ID>
 */
public interface GenericDao<T,ID> {
    
    public void create(T entity);
    public void modify(T entity);
    public void delete(T entity);
    public T findById(ID id);
    public List<T> findAll();
       
}
