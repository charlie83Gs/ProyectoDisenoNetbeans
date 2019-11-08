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

    public GetAllCommand(Payload payload) {
        this.payload = payload;
    }
    Payload payload;
    
    /**
     * @see "class" Class
     * @return 
     */
    @Override
    public ArrayList<T> execute() {
        Class clazz = (Class) payload.getContent("class");
        return PersistanceData.findAll(clazz);
    }
    
    
}
