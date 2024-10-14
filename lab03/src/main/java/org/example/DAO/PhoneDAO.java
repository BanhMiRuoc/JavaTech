package org.example.DAO;


import org.example.HibernateUtils;
import org.example.models.Phone;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class PhoneDAO implements Repository<Phone> {

    @Override
    public boolean add(Phone phone) {
        try (Session sess = HibernateUtils.getSessionFactory().openSession()) {
            Transaction tx = sess.beginTransaction();
            sess.save(phone);
            tx.commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Phone get(int id) {
        try (Session sess = HibernateUtils.getSessionFactory().openSession()) {
            return sess.get(Phone.class, id);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Phone> getAll() {
        try (Session sess = HibernateUtils.getSessionFactory().openSession()) {
            return sess.createQuery("from Phone", Phone.class).list();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean remove(int id) {
        try (Session sess = HibernateUtils.getSessionFactory().openSession()) {
            Transaction tx = sess.beginTransaction();
            Phone phone = sess.get(Phone.class, id);
            if (phone != null) {
                sess.delete(phone);
                tx.commit();
                return true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean remove(Phone phone) {
        try (Session sess = HibernateUtils.getSessionFactory().openSession()) {
            Transaction tx = sess.beginTransaction();
            if (phone != null) {
                sess.delete(phone);
                tx.commit();
                return true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Phone phone) {
        try (Session sess = HibernateUtils.getSessionFactory().openSession()) {
            Transaction tx = sess.beginTransaction();
            sess.update(phone);
            tx.commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Phone getPhoneWithHighestPrice() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from Phone order by price desc", Phone.class)
                    .setMaxResults(1)
                    .uniqueResult();
        }
    }
    public List<Phone> getPhonesSortedByCountryAndPrice() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from Phone order by country asc, price desc", Phone.class)
                    .list();
        }
    }
    public boolean isPhoneAbove50Million() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            Long count = session.createQuery("select count(p) from Phone p where p.price > 50000000", Long.class)
                    .uniqueResult();
            return count > 0;
        }
    }
    public Phone getFirstPinkPhoneOver15Million() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from Phone where color = :color and price > 15000000", Phone.class)
                    .setParameter("color", "Pink")
                    .setMaxResults(1)
                    .uniqueResult();
        }
    }
}
