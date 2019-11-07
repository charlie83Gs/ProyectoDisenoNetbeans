/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno;

import com.diseno.proyecto1diseno.HibernateORM.ClientCRUD;
import com.diseno.proyecto1diseno.HibernateORM.EmployeeCRUD;
import com.diseno.proyecto1diseno.HibernateORM.HibernateUtil;
import com.diseno.proyecto1diseno.model.Client;
import com.diseno.proyecto1diseno.model.Employee;

/**
 *
 * @author Charlie
 */
public class Test {
    
    
    public static void fullTest(){
        //testEmployeeCrud();
        testClientCrud();
    }
    
    public static void testEmployeeCrud(){
        HibernateUtil.getSessionFactory().getCurrentSession();
        Employee emp = new Employee("Charlie","63387898","carlos@gmail.com", "1234");
        Employee emp2 = new Employee("Bryan","22222222","malabaryan@gmail.com", "1234");
        Employee emp3 = new Employee("Evelio","33333333","evelio@gmail.com", "1234");
        Employee emp4 = new Employee("Kenneth","44444444","kennetg@gmail.com", "4321");
        
        //EmployeeCRUD.insert(emp);
        //EmployeeCRUD.insert(emp2);
        //EmployeeCRUD.insert(emp3);
        //EmployeeCRUD.insert(emp4);

        
        //HibernateUtil.getSessionFactory();
    }
    
    public static void testClientCrud(){
        HibernateUtil.getSessionFactory().openSession();
        Client emp = new Client("Charlie","63387898","carlos@gmail.com", "1234");
        Client emp2 = new Client("Bryan","22222222","malabaryan@gmail.com", "1234");
        Client emp3 = new Client("Evelio","33333333","evelio@gmail.com", "1234");
        Client emp4 = new Client("Kenneth","44444444","kennetg@gmail.com", "4321");
        
        ClientCRUD.insert(emp);
        //EmployeeCRUD.insert(emp2);
        //EmployeeCRUD.insert(emp3);
        //EmployeeCRUD.insert(emp4);

        
        //HibernateUtil.getSessionFactory();
    }
}
