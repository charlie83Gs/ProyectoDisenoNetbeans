/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Evelio
 */
@Entity
@Table(name="clients")
public class Client extends User{
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Disease> diseases = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Treatment> treatments = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Complain> complains = new ArrayList<>();
    
    private Client(){
        
    }
    
    public Client(String name, String phone, String email, String password) {
        super(name, phone, email, password);
    }

    /**
     * @return the diseases
     */
    public List<Disease> getDiseases() {
        return diseases;
    }
    
    public void addDisease(Disease disease){
        diseases.add(disease);
    }
    
    /**
     * @return the treatments
     */
    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void addTreatment(Treatment treatment){
        treatments.add(treatment);
    }
    
    /**
     * @return the complains
     */
    public List<Complain> getComplains() {
        return complains;
    }
    
    public void addComplain(Complain complain){
        complains.add(complain);
    }

    @Override
    public String toString() {
        return "Client{" + name + '}';
    }
    
}
