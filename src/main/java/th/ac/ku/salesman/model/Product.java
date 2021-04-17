package th.ac.ku.salesman.model;

public class Product {
    private int productId;
    private String productName, productUnit, productPrice;

    public Product(int productId, String productName, String productUnit, String productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productUnit = productUnit;
        this.productPrice = productPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
