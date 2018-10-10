/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Guilherme Henrique Bialas
 */
public class Conexao {
    private StandardServiceRegistry sr = null;
    private SessionFactory factory = null;
    private Transaction transaction = null;
    private Session session = null;
    
    public boolean conectar(){
        sr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        factory = new Configuration().buildSessionFactory(sr);
        try {
            session = factory.openSession();
            transaction = session.getTransaction();
            transaction.begin();
            return true;
        } catch (HibernateException e) {
         e.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
     return false;
        }
    }
    
}
