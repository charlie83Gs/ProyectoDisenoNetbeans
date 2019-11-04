/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno.model;

/**
 *
 * @author Charlie
 * 
 * Todo 
 * Add client to client request
 * Add employee to employee request
 * 
 */
public class RequestFactory {
    
    public EmployeeRequest createEmployeeRequest(RequestType type, Object payload, Employee employee){
        return new EmployeeRequest(type, payload, employee);
    }
    
    public ClientRequest createClientRequest(RequestType type, Object payload, Client client){
        return new ClientRequest(type, payload, client);
    }
}
