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
public class ClientRequest implements Request{
    private RequestType type;
    private Object payload;
    Client client;

    public ClientRequest(RequestType type, Object payload, Client client) {
        this.type = type;
        this.payload = payload;
        this.client = client;
    }
    

    
    @Override
    public RequestType getType() {
        return type;
    }
    @Override
    public void setType(RequestType type) {
        this.type = type;
    }
    @Override
    public Object getPayload() {
        return payload;
    }
    @Override
    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public Client getClient() {
        return client;
    }

    public ClientRequest() {
    }

}
