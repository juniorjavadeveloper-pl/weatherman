package pl.juniorjavadeveloper.project.weatherman.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateDaoUtils {
    // Create the SessionFactory when you start the application.
    private static final SessionFactory SESSION_FACTORY;

    static {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

//        try {
            SESSION_FACTORY = new MetadataSources(serviceRegistry)
                    .buildMetadata()
                    .buildSessionFactory();
//        } catch (Exception e) {
//            e.printStackTrace();
//            StandardServiceRegistryBuilder.destroy(serviceRegistry);
//        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
