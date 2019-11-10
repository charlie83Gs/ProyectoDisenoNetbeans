/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno.model;

import java.util.ArrayList;

/**
 *
 * @author Charlie
 */
public class ServiceBuilder {
    private String name;
    private Public targetPublic;
    private ArrayList<Schedule> schedules;

    public ServiceBuilder() {
        schedules = new ArrayList<>();
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPublic(Public targetPublic){
        this.targetPublic = targetPublic;
    }
    
    public void addSchedule(Schedule schedule){
        schedules.add(schedule);
    }
    
    public Service getResult(){
        //Schedule[] scheduleArray = (Schedule[])schedules.toArray();
        return new Service(name,targetPublic,schedules);
    }
    
    
}
