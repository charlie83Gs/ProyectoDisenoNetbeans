/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno.model;

import java.util.Date;
/**
 *
 * @author Evelio
 */
public class ServiceContract {

    private Service service;
    private Employee employee;
    private Date dateStart;
    private Date dateEnd;
    
    public ServiceContract(Service service, Employee employee, Date dateStart, Date dateEnd) {
        this.service = service;
        this.employee = employee;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
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
}