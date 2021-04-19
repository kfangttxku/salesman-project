package th.ac.ku.salesman.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    private int orderId, customerId, salesmanId, productId, productUnit;
    private String orderStatus;
    private java.sql.Date orderDate;

    public Order(int orderId, int customerId, int salesmanId, int productId, int productUnit, String orderStatus, java.sql.Date orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.salesmanId = salesmanId;
        this.productId = productId;
        this.productUnit = productUnit;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(int salesmanId) {
        this.salesmanId = salesmanId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(int productUnit) {
        this.productUnit = productUnit;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(java.sql.Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", salesmanId=" + salesmanId +
                ", productId=" + productId +
                ", productUnit=" + productUnit +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }
}
