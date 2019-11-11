/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.command;

import com.diseno.proyecto1diseno.HibernateORM.PersistanceData;
import controller.Payload;
import java.util.ArrayList;

/**
 *
 * @author Charlie
 */
public class GetAllCommand<T> implements Command{
    
    /**
     * Requires a payload containing
     * "class" Class
     * @return 
     */
    public GetAllCommand(Payload payload) throws Exception {
        this.payload = payload;
        if(!this.payload.contains("class")) throw new Exception("Invalid payload requires \"class\" of type Class");
    }
    Payload payload;
    
    /**
     * Requires a payload containing
     * "class" Class
     * @return Arraylist<T>
     */
    @Override
    public ArrayList<T> execute() {
        Class clazz = (Class) payload.getContent("class");
        return PersistanceData.findAll(clazz);
    }
    
    
}
