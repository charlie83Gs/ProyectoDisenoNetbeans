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
public class Treatment {
    private int idTreatment;
    private String name;
    private String description;
    
    public Treatment(int idTreatment, String name, String description) {
        this.idTreatment = idTreatment;
        this.name = name;
        this.description = description;
    }
    
    public int getIdDisease() {
        return idTreatment;
    }

    public void setIdDisease(int idDisease) {
        this.idTreatment = idDisease;
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
