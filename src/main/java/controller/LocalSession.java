/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.diseno.proyecto1diseno.HibernateORM.PersistanceData;
import com.diseno.proyecto1diseno.model.Client;
import com.diseno.proyecto1diseno.model.Employee;
import com.diseno.proyecto1diseno.model.User;
import java.util.HashMap;

/**
 *
 * @author Charlie
 */
public class LocalSession {
    // static variable single_instance of type Singleton 
    private static LocalSession single_instance = null; 
    private HashMap<String, Object> sesionData = new HashMap<>();
    
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
        user = PersistanceData.validateLoginCli(name, password);
        if (user != null) type = SessionType.CLIENT;
        user = PersistanceData.validateLoginEmp(name, password);
        if (user != null) type = SessionType.EMPLOYEE;

        return user != null;
    }
    
    public boolean loginClient(String name, String password){
        Client clt = PersistanceData.validateLoginCli(name, password);
        user = clt;
        if (user != null) type = SessionType.CLIENT;
        addData("sessionClient", clt);
        return user != null;
    }
    
     public boolean loginEmployee(String name, String password){
        Employee emp = PersistanceData.validateLoginEmp(name, password);
        user = emp;
        if (user != null) type = SessionType.EMPLOYEE;
        addData("sessionEmployee", emp);
        return user != null;
    }

    
    
    public void addData(String key, Object data){
        sesionData.put(key, data);
    } 
    
    public Object getData(String key){
        return sesionData.get(key);
    }
    
    public boolean contains(String key){
        return sesionData.containsKey(key);
    }
}
