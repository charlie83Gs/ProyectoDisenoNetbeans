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
public class GetByIdCommand<T> implements Command{
    /**
     * Requires a payload containing
     * "id" id
     * "class" Class @entity
     * @return T
     */
    public GetByIdCommand(Payload payload) throws Exception {
        this.payload = payload;
        if(!this.payload.contains("id")) throw new Exception("Invalid payload requires \"id\" of type Integer");
        if(!this.payload.contains("class")) throw new Exception("Invalid payload requires \"class\" of type Class");
    }
    Payload payload;
    /**
     * Requires a payload containing
     * "id" id
     * "class" Class @entity
     * @return T
     */
    @Override
    public T execute() {
        int id = (Integer)payload.getContent("id");
        Class clazz = (Class) payload.getContent("class");
        
        return (T)PersistanceData.find(id, clazz);
    }
    
}
