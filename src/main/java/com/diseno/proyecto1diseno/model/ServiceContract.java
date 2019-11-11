/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.Id;

/**
 *
 * @author Evelio
 */
@Entity
@Table(name="servicecontracts")
public class ServiceContract {
    @Id
    private int id;
    @OneToOne
    private Service service;
    @OneToOne
    private Employee employee;
    private Date dateStart;
    private Date dateEnd;
    @OneToOne
    private Client cliente;
    @OneToOne
    private AttentionCenter attentionCenter;
    private float cost;

    public ServiceContract() {
    }
    
    
    
    public ServiceContract(Service service, Employee employee, Date dateStart, Date dateEnd, AttentionCenter attentionCenter,float cost ) {
        this.service = service;
        this.employee = employee;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.attentionCenter = attentionCenter;
        this.cost = cost;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    } 

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }
    
    public double getContractCost(){
        double totalCost = getService().getTargetPublic().getCost();
        for (Study study : employee.getStudies()){
            totalCost += study.getPayment();
        }
        return totalCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }

    public AttentionCenter getAttentionCenter() {
        return attentionCenter;
    }

    public void setAttentionCenter(AttentionCenter attentionCenter) {
        this.attentionCenter = attentionCenter;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

}
