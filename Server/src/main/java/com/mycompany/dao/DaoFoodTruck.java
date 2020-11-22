/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.dto.DtoFoodTruck;
import java.util.List;

/**
 *
 * @author adriel
 */
public interface DaoFoodTruck extends GenericDao<DtoFoodTruck,Long> {
    
    public List<DtoFoodTruck> findAllFrom(Long idInspector);
}
