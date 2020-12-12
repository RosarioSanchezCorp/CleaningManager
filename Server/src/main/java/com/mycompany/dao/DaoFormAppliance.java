/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.DtoFormAppliance;
import com.mycompany.supports.Registry;
import java.util.List;

/**
 *
 * @author adriel
 */
public interface DaoFormAppliance extends GenericDao<DtoFormAppliance,Long>{
    
    public List<Registry> findAllRegistries();
    public Registry findLast();
}
