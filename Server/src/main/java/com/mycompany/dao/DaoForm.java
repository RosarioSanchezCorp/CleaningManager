/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.DtoForm;

/**
 *
 * @author adriel
 */
public interface DaoForm extends GenericDao<DtoForm,Long>{
    
    public DtoForm findLast();
    
}
