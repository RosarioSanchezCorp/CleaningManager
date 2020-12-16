/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.mycompany.supports.Registry;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

/**
 *
 * @author alex_rosario
 */
public class FileHandler {
    
    public static void saveCSV(String path, List<Registry> registryList){
        
        try{
            File file = new File(path);
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            Writer w = new BufferedWriter(osw);
            w.write("ID_FORM, INSPECTOR, PHONE_NUMBER, INSPECTION_TIME, FOODTRUCK, CLEANING_STATUS, OPERATOR, PHONE_NUMBER, DESCRIPTION");
            for(Registry r: registryList){
                w.write("\n"+r.getId()+", "+r.getInspectorName()+", "+r.getInspectorPhoneNumber()+", "+r.getInspectionTime()+", "+r.getIdFoodTruck()+", "
                        +r.getCleaningStatus()+", "+r.getOperatorName()+", "+r.getOperatorPhoneNumber()+", "+r.getDescription());
            }
            w.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
