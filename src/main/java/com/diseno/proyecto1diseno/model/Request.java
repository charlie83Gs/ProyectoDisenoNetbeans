/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno.model;

/**
 *
 * @author Charlie
 */
public  interface Request {
    public RequestType getType();
    public void setType(RequestType type);
    public Object getPayload();
    public void setPayload(Object payload);
    
   
    
}
