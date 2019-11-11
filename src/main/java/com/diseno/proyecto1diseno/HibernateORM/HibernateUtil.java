/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno.HibernateORM;

import com.diseno.proyecto1diseno.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Kenneth
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            Configuration connection = new Configuration().configure()
                .addAnnotatedClass(Disease.class)
                .addAnnotatedClass(Treatment.class)
                .addAnnotatedClass(Complain.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Role.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Calification.class)
                .addAnnotatedClass(Study.class)
                .addAnnotatedClass(Public.class)
                .addAnnotatedClass(Schedule.class)
                .addAnnotatedClass(Service.class)
                ;
            
            sessionFactory = connection.buildSessionFactory();
            
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
