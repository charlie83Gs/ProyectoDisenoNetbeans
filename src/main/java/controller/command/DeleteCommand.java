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

    public DeleteCommand(Payload payload) {
        this.payload = payload;
    }
    Payload payload;

    /**
     * @see "id" : int
     * @see "class" : Class
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
