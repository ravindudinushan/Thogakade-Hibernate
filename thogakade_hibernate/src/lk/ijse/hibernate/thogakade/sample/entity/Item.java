package lk.ijse.hibernate.thogakade.sample.entity;

import javax.persistence.*;

@Entity(name = "item")
public class Item {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "unitPrice")
    private double unitPrice;

    @Column(name = "qtyOnHand")
    private int qty;

    public Item(){}

    public Item(String code, String description, double unitPrice, int qty) {
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitePrice) {
        this.unitPrice = unitePrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Item{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", qty=" + qty +
                '}';
    }
}
