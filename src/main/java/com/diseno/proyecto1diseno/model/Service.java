/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Charlie
 */
@Entity
@Table(name="services")
public class Service {
    @Id
    private int id;
    private String name;
    @OneToOne
    private Public targetPublic;
    @OneToMany()
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Schedule> schedules = new ArrayList<Schedule>();

    public Service(String name, Public targetPublic, Schedule[] schedules) {
        this.name = name;
        this.targetPublic = targetPublic;
        this.schedules = schedules;
    }
    
    
}
