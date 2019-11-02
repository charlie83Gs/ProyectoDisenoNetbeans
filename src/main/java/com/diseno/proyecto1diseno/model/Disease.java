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
public class Disease {

    private int idDisease;
    private String name;
    private String description;
    
    public Disease(int idDisease, String name, String description) {
        this.idDisease = idDisease;
        this.name = name;
        this.description = description;
    }
    
    public int getIdDisease() {
        return idDisease;
    }

    public void setIdDisease(int idDisease) {
        this.idDisease = idDisease;
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
