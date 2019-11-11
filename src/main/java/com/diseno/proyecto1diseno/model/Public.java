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
@Table(name="publics")
public class Public {
    @Id
    @GeneratedValue
    private int id;
    String name;
    float cost;
    float payment;

    public Public() {
    }

    public Public(String name, float cost, float payment) {
        this.name = name;
        this.cost = cost;
        this.payment = payment;
    }
    
    

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
    
    

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public int getId() {
        return id;
    }
    
    
    
    
}
