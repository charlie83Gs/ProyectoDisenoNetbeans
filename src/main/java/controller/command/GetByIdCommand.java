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

    public GetByIdCommand(Payload payload) {
        this.payload = payload;
    }
    Payload payload;
    /**
     * @see "id" id
     * @see "class" Class @entity
     * @return T
     */
    @Override
    public T execute() {
        int id = (Integer)payload.getContent("id");
        Class clazz = (Class) payload.getContent("class");
        
        return (T)PersistanceData.find(id, clazz);
    }
    
}
