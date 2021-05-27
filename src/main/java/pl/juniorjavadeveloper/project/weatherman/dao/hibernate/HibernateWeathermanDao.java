package pl.juniorjavadeveloper.project.weatherman.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class HibernateWeathermanDao {
    private static final Logger LOGGER = Logger.getLogger(HibernateWeathermanDao.class.getName());

    // L - list aka. listLocations()
    public List<LocationEntity> list() {
        LOGGER.info("list()");
        List<LocationEntity> locations = new ArrayList<>();

        Session session = HibernateDaoUtils.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            // Begin a transaction
            transaction = session.beginTransaction();
            // Query the Locations
            locations = session.createQuery("from locations", LocationEntity.class).getResultList();
            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            e.printStackTrace();
        } finally {
            // Close the session
            session.close();
        }

        LOGGER.info("list() = " + locations);
        return locations;
    }

    // C - create aka. addLocation(...)
    public LocationEntity create(LocationEntity locationEntity) {
        LOGGER.info("create(" + locationEntity + ")");

        Session session = HibernateDaoUtils.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            // Begin a transaction
            transaction = session.beginTransaction();
            // Save the Location
            Long savedLocationId = (Long) session.save(locationEntity);
            // Commit the transaction
            transaction.commit();

            locationEntity.setId(savedLocationId);
        } catch (Exception e) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            e.printStackTrace();
        } finally {
            // Close the session
            session.close();
        }

        return locationEntity;
    }

    // R - read aka. getLocationWeather(...)
    public LocationEntity read(Long id) {
        LOGGER.info("read(" + id + ")");

        Session session = HibernateDaoUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        LocationEntity locationEntity = null;

        try {
            // Begin a transaction
            transaction = session.beginTransaction();
            // Save the Location
            locationEntity = session.get(LocationEntity.class, id);
            // Commit the transaction
            transaction.commit();

        } catch (Exception e) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            e.printStackTrace();
        } finally {
            // Close the session
            session.close();
        }

        return locationEntity;
    }

    // U - update aka. saveLocationWeather(...)
    public LocationEntity update(LocationEntity locationEntity) {
        LOGGER.info("update(" + locationEntity + ")");

        Session session = HibernateDaoUtils.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            // Begin a transaction
            transaction = session.beginTransaction();
            // Save the Location
            session.saveOrUpdate(locationEntity);
            // Commit the transaction
            transaction.commit();

        } catch (Exception e) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            e.printStackTrace();
        } finally {
            // Close the session
            session.close();
        }

        return locationEntity;
    }
}
