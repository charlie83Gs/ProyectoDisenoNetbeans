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

    public LoginCommand(Payload payload) {
        this.payload = payload;
    }
    Payload payload;
    
    /**
     * @see "name" String
     * @see "pasword" String 
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
