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
public class FindCommand <T> implements Command{
    /**
     * Requires a payload containing
     * select * where param = value
     * "param" param name
     * "value" param value to search
     * "class" Class @entity
     * @return T
     */
    public FindCommand(Payload payload) throws Exception {
        this.payload = payload;
        if(!this.payload.contains("param")) throw new Exception("Invalid payload requires \"param\" of type String");
        if(!this.payload.contains("value")) throw new Exception("Invalid payload requires \"value\" of type String");
        if(!this.payload.contains("class")) throw new Exception("Invalid payload requires \"class\" of type Class");
    }
    Payload payload;
    /**
     * @see  select * where param = value
     * @see  "param" param name
     * @see  "value" param value to search
     * @see  "class" Class @entity
     * @return T
     */
    @Override
    public T execute() {
        String param = (String)payload.getContent("param");
        String value = (String)payload.getContent("value");
        Class clazz = (Class) payload.getContent("class");
        
        return (T)PersistanceData.findByParam(param,value, clazz);
    }
    
}
