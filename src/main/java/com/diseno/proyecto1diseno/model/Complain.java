/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno.model;

/**
 *
 * @author Evelio
 */
public class Complain {
    private int idComplain;
    private String name;
    private String description;
    
    public Complain(int idComplain, String name, String description) {
        this.idComplain = idComplain;
        this.name = name;
        this.description = description;
    }
    
    public int getIdComplain() {
        return idComplain;
    }

    public void setIdComplain(int idComplain) {
        this.idComplain = idComplain;
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
