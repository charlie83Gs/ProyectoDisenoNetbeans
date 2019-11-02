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
public class Service {
    private String name;
    private Public targetPublic;
    private Schedule[] schedules;

    public Service(String name, Public targetPublic, Schedule[] schedules) {
        this.name = name;
        this.targetPublic = targetPublic;
        this.schedules = schedules;
    }
    
    
}
