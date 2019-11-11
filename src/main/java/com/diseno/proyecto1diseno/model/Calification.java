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
@Table(name="califications")
public class Calification {
    private int value;
    @Id
    @GeneratedValue
    private int id;
    private String comment;
    
    public Calification() {
    }
    
}
