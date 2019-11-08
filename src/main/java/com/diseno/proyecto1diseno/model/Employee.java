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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


/**
 *
 * @author Charlie
 * 
 * TODO
 * -add studies
 * 
 * 
 */

@Entity
@Table(name="employees")
public class Employee extends User{
    @OneToMany()
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Role> roles = new ArrayList<>();
    @OneToMany()
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Calification> califications = new ArrayList<>();
    @OneToMany()
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Study> studies = new ArrayList<>();
    
    
    private Employee(){
        
    }
    
    public Employee(String name, String phone, String email, String password) {
        super(name, phone, email, password); 
    }
    
    public Employee(String name, String phone, String email, String password,
                List<Role> roles, List<Calification> califications, List<Study> studies) {
        super(name, phone, email, password);
        this.roles = roles;
        this.califications = califications;
        this.studies = studies;
        
    }

    /**
     * @return the roles
     */
    public List<Role> getRoles() {
        return roles;
    }
    
    public void addRole(Role role){
        roles.add(role);
    }

    /**
     * @return the califications
     */
    public List<Calification> getCalifications() {
        return califications;
    }

    public void addCalification(Calification calificaction){
        califications.add(calificaction);
    }
    
    /**
     * @return the studies
     */
    public List<Study> getStudies() {
        return studies;
    }
    
    public void addStudy(Study study){
        studies.add(study);
    }

}
