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
public class DeleteCommand<T> implements Command{

    /**
     * Requires a payload containing
     * "id" : int
     * "class" : Class
     * @return null
     */
    public DeleteCommand(Payload payload) throws Exception {
        this.payload = payload;
        if(!this.payload.contains("class")) throw new Exception("Invalid payload requires \"class\" of type T");
        if(!this.payload.contains("id")) throw new Exception("Invalid payload requires \"id\" of type Integer");
    }
    Payload payload;

    /**
     * @see  "id" : int
     * @see  "class" : Class
     * @return null
     */
    @Override
    public T execute() {
        
        int id = (Integer)payload.getContent("id");
        Class clazz = (Class) payload.getContent("class");
        
        PersistanceData.delete(id, clazz);
        return null;
    }
    
    
}
