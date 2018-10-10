
import javax.security.auth.login.AppConfigurationEntry;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Guilheme Henrique Bialas
 */
public class Principal {

    public static void main(String[] args) {

        Configuration conf = new Configuration();

        StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xnl").build();

        SessionFactory factory = new Configuration().buildSessionFactory(sr);
        
        Transaction transaction = null;
        try {
            Session session = factory.openSession();
            transaction = session.getTransaction();
            transaction.begin();
            
            //INSERT NO HD
            transaction.commit();
        } catch (HibernateException e) {
        e.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
                
            }finally{
            factory.close();
        }

    }

}
