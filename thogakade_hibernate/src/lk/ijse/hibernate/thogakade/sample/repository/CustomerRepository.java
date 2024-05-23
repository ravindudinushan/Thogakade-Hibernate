package lk.ijse.hibernate.thogakade.sample.repository;

import lk.ijse.hibernate.thogakade.sample.config.SessionFactoryConfig;
import lk.ijse.hibernate.thogakade.sample.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomerRepository {

    private final Session session;

    public CustomerRepository() {
        session = SessionFactoryConfig.getInstance().getSession();
    }

    public boolean saveCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
        try {
            session.save(customer);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    public boolean updateCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
        try {
            session.update(customer);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    public boolean deleteCustomer(Customer customer){
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(customer);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    public List<Customer> getAllCustomer() {

        try {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
            Root<Customer> root = criteriaQuery.from(Customer.class);
            criteriaQuery.select(root);

            Query<Customer> query = session.createQuery(criteriaQuery);
            List<Customer> allCustomer = query.getResultList();

            return allCustomer;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
