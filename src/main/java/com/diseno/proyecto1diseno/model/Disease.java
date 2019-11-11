/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Evelio
 */
@Entity
@Table(name="diseases")
public class Disease {
    private static int CID = 0;
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    
    public Disease(String name, String description) {
        this.id = CID++;
        this.name = name;
        this.description = description;
    }

    public Disease() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
