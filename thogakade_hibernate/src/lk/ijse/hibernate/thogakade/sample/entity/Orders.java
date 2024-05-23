package lk.ijse.hibernate.thogakade.sample.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "orders")
public class Orders {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "date")
    @CreationTimestamp
    private Timestamp date;

    @Column(name = "customerId")
    private String cusId;

    public Orders(){}

    public Orders(String id, Timestamp date, String cusId) {
        this.id = id;
        this.date = date;
        this.cusId = cusId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", cusId='" + cusId + '\'' +
                '}';
    }
}
