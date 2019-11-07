/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno.HibernateORM;

import java.util.List;
import com.diseno.proyecto1diseno.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Kenneth
 */
public class EmployeeCRUD {
    
    public static void insert(Employee employee){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        Transaction trans = session.beginTransaction();
        
        session.save(employee);
        
        trans.commit();
    }
    
    public static Employee find(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            Transaction trans = session.beginTransaction();

            Employee object = (Employee) session.get(Employee.class, id);

            trans.commit();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<Employee> execute(String hqlQuery){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        Query query = session.createQuery(hqlQuery);
        trans.commit();
        return query.list();
    }
    
    public static void delete(int id)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.delete(find(id));
        session.flush();
    }
}
