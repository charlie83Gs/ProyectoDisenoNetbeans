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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Charlie
 */
@Entity
@Table(name="services")
public class Service {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    private Public targetPublic;
    @OneToMany()
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Schedule> schedules = new ArrayList<Schedule>();

    public Service() {
    }

    
    
    public Service(String name, Public targetPublic,  List<Schedule> schedules) {
        this.name = name;
        this.targetPublic = targetPublic;
        this.schedules = schedules;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Public getTargetPublic() {
        return targetPublic;
    }

    public void setTargetPublic(Public targetPublic) {
        this.targetPublic = targetPublic;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
    
    
}
