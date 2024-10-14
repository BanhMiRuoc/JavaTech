package org.example.DAO;

import org.example.models.Manufacturer;

import org.example.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;


public class ManufacturerDAO implements Repository<Manufacturer>{

    @Override
    public boolean add(Manufacturer manufacturer) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(manufacturer);
            tx.commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Manufacturer get(int id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Manufacturer manufacturer = session.get(Manufacturer.class, id);
            tx.commit();
            return manufacturer;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Manufacturer> getAll() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            List<Manufacturer> list = session.createQuery("from Manufacturer", Manufacturer.class).list();
            tx.commit();
            return list;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean remove(int id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Manufacturer manufacturer = session.get(Manufacturer.class, id);
            session.delete(manufacturer);
            tx.commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(Manufacturer manufacturer) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(manufacturer);
            tx.commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Manufacturer manufacturer) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(manufacturer);
            tx.commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean allManufacturersHaveMoreThan100Employees() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Long count = session.createQuery("select count(m) from Manufacturer m where m.employee <= 100", Long.class)
                    .uniqueResult();
            return count == 0;
        }
    }
    public int getSumOfAllEmployees() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Long sum = session.createQuery("select sum(m.employee) from Manufacturer m", Long.class)
                    .uniqueResult();
            return sum != null ? sum.intValue() : 0;
        }
    }
    public Manufacturer getLastManufacturerBasedInUS() throws IllegalStateException {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            List<Manufacturer> manufacturers = session.createQuery("from Manufacturer where location = :location order by id desc", Manufacturer.class)
                    .setParameter("location", "US")
                    .list();

            if (manufacturers.isEmpty()) {
                throw new IllegalStateException("No manufacturer based in the US was found.");
            }

            return manufacturers.getFirst();
        }
    }

}
