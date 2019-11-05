/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno.HibernateORM;

import java.util.List;
import com.diseno.proyecto1diseno.model.Client;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Kenneth
 */
public class ClientCRUD {
    public static void insert(Client client){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        Transaction trans = session.beginTransaction();
        
        session.save(client);
        
        trans.commit();
    }
    
    public static Client find(int id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            Transaction trans = session.beginTransaction();

            Client object = (Client) session.get(Client.class, id);

            trans.commit();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<Client> execute(String hqlQuery){
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
