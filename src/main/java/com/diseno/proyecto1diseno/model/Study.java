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
@Table(name="studys")
public class Study {
    @Id
    @GeneratedValue
    private int id;
    private String study;
    private float cost;
    private float payment;

    public Study(String study, float cost, float payment) {
        this.study = study;
        this.cost = cost;
        this.payment = payment;
    }

    public String getStudy() {
        return study;
    }

    public Study() {
    }

    public void setStudy(String study) {
        this.study = study;
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

    @Override
    public String toString() {
        return  study;
    }
    
    
    
}
