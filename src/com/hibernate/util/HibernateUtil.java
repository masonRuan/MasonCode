/*
 * This class not only produces the global org.hibernate.SessionFactory reference in its static initializer;
 * it also hides the fact that it uses a static singleton
*/

package com.hibernate.util;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;


//http://stackoverflow.com/questions/8621906/is-buildsessionfactory-deprecated-in-hibernate-4

public class HibernateUtil {
//    private static final SessionFactory sessionFactory;
//
//    static {
//        try {
//            // Create the SessionFactory from hibernate.cfg.xml
//            Configuration cfg = new Configuration().configure();
//			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
//			sessionFactory = cfg.buildSessionFactory(serviceRegistry);
//        } catch (Throwable ex) {
//            // Make sure you log the exception, as it might be swallowed
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}