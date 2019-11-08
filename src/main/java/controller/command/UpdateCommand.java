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
public class UpdateCommand<T> implements Command{

    public UpdateCommand(Payload payload) {
        this.payload = payload;
    }
    Payload payload;
     /**
     * @see "object" Object @entity
     * @return null
     */
    @Override
    public Object execute() {
        Object object = payload.getContent("object");
        PersistanceData.update(object);
        return null;
    }
    
    
}
