/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.command;

import com.diseno.proyecto1diseno.HibernateORM.PersistanceData;
import controller.LocalSession;
import controller.Payload;

/**
 *
 * @author Charlie
 */
public class LoginCommand<T> implements Command{

    /**
     * Requires a payload containing
     * "name" String
     * "password" String 
     * @return Boolean
     */
    public LoginCommand(Payload payload) throws Exception {
        this.payload = payload;
        if(!this.payload.contains("name")) throw new Exception("Invalid payload requires \"name\" of type String");
        if(!this.payload.contains("password")) throw new Exception("Invalid payload requires \"password\" of type String");
    }
    Payload payload;
    
    /**
     * Requires a payload containing
     *  "name" String
     *  "pasword" String 
     * @return Boolean
     */
    @Override
    public Object execute() {
        String name = (String)payload.getContent("name");
        String password = (String)payload.getContent("password");
        
        boolean res = LocalSession.getInstance().login(name, password);
        return res;
    }
    
    
}
