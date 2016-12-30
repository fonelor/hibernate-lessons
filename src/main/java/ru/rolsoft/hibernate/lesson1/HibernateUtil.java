package ru.rolsoft.hibernate.lesson1;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;

import java.io.File;

/**
 * Created by rolenof on 29.12.16.
 */
@Slf4j
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildsSessionFactory();

    private static SessionFactory buildsSessionFactory() {
        try {
            return new org.hibernate.cfg.Configuration()
                    .configure(
                            new File(SessionFactory.class.getClassLoader().getResource("hibernate.cfg.xml").getFile())
                    ).buildSessionFactory();
        } catch (Throwable ex) {
            log.error("Initial SessionFactory failed", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
