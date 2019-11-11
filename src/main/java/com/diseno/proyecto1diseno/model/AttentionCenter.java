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
 * @author Charlie
 */
@Entity
@Table(name="attentioncenters")
public class AttentionCenter {
    @Id
    @GeneratedValue
    private int id;
    String name;
    
    public AttentionCenter() {
    }

    public AttentionCenter(String name) {
        this.name = name;
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
    
}
