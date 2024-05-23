package lk.ijse.hibernate.thogakade.sample.repository;

import lk.ijse.hibernate.thogakade.sample.config.SessionFactoryConfig;
import lk.ijse.hibernate.thogakade.sample.entity.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OrderRepository {
    private final Session session;

    public OrderRepository() {
        session = SessionFactoryConfig.getInstance().getSession();
    }

    public boolean saveOrder(Orders orders){
        Transaction transaction = session.beginTransaction();
        try {
            session.save(orders);
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

    public boolean updateOrder(Orders orders){
        Transaction transaction = session.beginTransaction();
        try {
            session.update(orders);
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

    public boolean deleteItem(Orders orders){
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(orders);
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

    public List<Orders> getAllOrder() {

        try {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Orders> criteriaQuery = criteriaBuilder.createQuery(Orders.class);
            Root<Orders> root = criteriaQuery.from(Orders.class);
            criteriaQuery.select(root);

            Query<Orders> query = session.createQuery(criteriaQuery);
            List<Orders> allOrder = query.getResultList();

            return allOrder;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
