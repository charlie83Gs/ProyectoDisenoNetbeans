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
public class Client {

    private Disease[] disease;
    private Treatment[] treatment;
    private Complain [] complain;
    
    public Client(Disease[] disease, Treatment[] treatment, Complain[] complain) {
        this.disease = disease;
        this.treatment = treatment;
        this.complain = complain;
    }

    public Disease[] getDisease() {
        return disease;
    }

    public void setDisease(Disease[] disease) {
        this.disease = disease;
    }

    public Treatment[] getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment[] treatment) {
        this.treatment = treatment;
    }

    public Complain[] getComplain() {
        return complain;
    }

    public void setComplain(Complain[] complain) {
        this.complain = complain;
    }
    
    
}
