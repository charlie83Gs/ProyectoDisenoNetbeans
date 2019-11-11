/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno.HibernateORM;

import com.diseno.proyecto1diseno.model.Client;
import com.diseno.proyecto1diseno.model.Employee;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Charlie
 */
public class PersistanceData {
    public static <T> void insert(T object){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        Transaction trans = session.beginTransaction();
        session.save(object);
        
        trans.commit();
    }
    
    public static <T> T find(int id, Class<T> clazz){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            Transaction trans = session.beginTransaction();

            T object = (T)session.get(clazz, id);
            
            trans.commit();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static <T> ArrayList<T> findAll(Class<T> clazz){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            Transaction trans = session.beginTransaction();

            ArrayList<T> object = (ArrayList<T>)session.createCriteria(clazz).list();
            
            trans.commit();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<T>();
        }
    }
    
    public static <T> List<T> execute(String hqlQuery){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction trans = session.beginTransaction();
        Query query = session.createQuery(hqlQuery);
        trans.commit();
        return query.list();
    }
    
    public static <T> void delete(int id, Class<T> clazz)
    {
        //find transaction
        T result = find(id,clazz);
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        //delete transaction
        Transaction trans = session.beginTransaction();
        
        if(result != null) session.delete(result);
        trans.commit();

    }
    
    public static <T> void update(T object){
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //-------------------------------------------------------------
        Transaction trans = session.beginTransaction();
        
        session.update(object);
        
        trans.commit();
        //-------------------------------------------------------------
    }
    
    public static <T> T findByParam(String param,String value, Class clazz){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //-------------------------------------------------------------
        Transaction trans = session.beginTransaction();
        
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq(param,value));
        T result = (T)criteria.uniqueResult();
        
        trans.commit();
        //-------------------------------------------------------------
        
     
        return result;
    }
    
     public static Client validateLoginCli(String clientName, String clientPassword){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //-------------------------------------------------------------
        Transaction trans = session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Client.class);
        criteria.add(Restrictions.eq("name",clientName));
        Client client = (Client)criteria.uniqueResult();
        
        trans.commit();
        //-------------------------------------------------------------
        
        if(client != null && client.getPassword().equals(clientPassword)) return client;
        return null;
    }
     
     public static Employee validateLoginEmp(String employeeName, String employeePassword){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //-------------------------------------------------------------
        Transaction trans = session.beginTransaction();
        
        Criteria criteria = session.createCriteria(Employee.class);
        criteria.add(Restrictions.eq("name",employeeName));
        Employee employee = (Employee)criteria.uniqueResult();
        
        trans.commit();
        //-------------------------------------------------------------
        
        if(employee != null && employee.getPassword().equals(employeePassword)) return employee;
        return null;
    }
    
    
    
}
