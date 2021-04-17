package th.ac.ku.salesman.model;

import java.util.Date;

public class Order {
    private int orderId, customerId, salesmanId, productId;
    private String orderStatus;
    private Date orderDate;

    public Order(int orderId, int customerId, int salesmanId, int productId, String orderStatus, Date orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.salesmanId = salesmanId;
        this.productId = productId;
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

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
