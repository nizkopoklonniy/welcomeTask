package com.springapp.utils;

import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Util for get session factory.
 */
public class HibernateUtil {

    /**
     * Configures session factory.
     * @return Session factory.
     */
    private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure();

        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }

    /**
     * ServiceRegistry for building SessionFactory.
     */
    private static ServiceRegistry serviceRegistry;

    /**
     * SessionFactory for create hibernate-session.
     */
    private static SessionFactory sessionFactory;

    /**
     * Gets session factory.
     * @return Session factory.
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null )
            sessionFactory =  configureSessionFactory();

        return sessionFactory;
    }
}