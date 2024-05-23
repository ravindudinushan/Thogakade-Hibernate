package lk.ijse.hibernate.thogakade.sample.repository;

import lk.ijse.hibernate.thogakade.sample.config.SessionFactoryConfig;
import lk.ijse.hibernate.thogakade.sample.entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ItemRepository {
    private final Session session;

    public ItemRepository() {
        session = SessionFactoryConfig.getInstance().getSession();
    }

    public boolean saveItem(Item item){
        Transaction transaction = session.beginTransaction();
        try {
            session.save(item);
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

    public boolean updateItem(Item item){
        Transaction transaction = session.beginTransaction();
        try {
            session.update(item);
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

    public boolean deleteItem(Item item){
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(item);
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

    public List<Item> getAllItem() {

        try {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Item> criteriaQuery = criteriaBuilder.createQuery(Item.class);
            Root<Item> root = criteriaQuery.from(Item.class);
            criteriaQuery.select(root);

            Query<Item> query = session.createQuery(criteriaQuery);
            List<Item> allItem = query.getResultList();

            return allItem;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
