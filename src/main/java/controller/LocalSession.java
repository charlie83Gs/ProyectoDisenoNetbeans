/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.diseno.proyecto1diseno.HibernateORM.PersistanceData;
import com.diseno.proyecto1diseno.model.User;

/**
 *
 * @author Charlie
 */
public class LocalSession {
    // static variable single_instance of type Singleton 
    private static LocalSession single_instance = null; 
    
    User user;
    SessionType type;
    

    // private constructor restricted to this class itself 
    private LocalSession() 
    { 
        
    } 
  
    // static method to create instance of Singleton class 
    public static LocalSession getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new LocalSession(); 
  
        return single_instance; 
    } 
    
    public boolean login(String name, String password){
        User user = PersistanceData.validateLoginCli(name, password);
        if (user != null) type = SessionType.CLIENT;
        user = PersistanceData.validateLoginEmp(name, password);
        if (user != null) type = SessionType.EMPLOYEE;
        
        return user != null;
    }
}
