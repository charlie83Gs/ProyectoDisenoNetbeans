/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.command;

import com.diseno.proyecto1diseno.HibernateORM.PersistanceData;
import controller.Payload;

/**
 *
 * @author Charlie
 */
public class AddCommand<T> implements Command{
    
    /**
     * Requires a payload containing
     *  "object" @entity
     * @return 
     */
    public AddCommand(Payload payload) throws Exception {
        this.payload = payload;
        if(!this.payload.contains("object")) throw new Exception("Invalid payload requires \"object\" of type T");
        
    }
    Payload payload;
    
    /**
     * Requires a payload containing
     * "object" @entity
     * @return 
     */
    @Override
    public T execute() {
        Object object = payload.getContent("object");
        PersistanceData.insert(object);
        return null;
    }
    
    
    
}
