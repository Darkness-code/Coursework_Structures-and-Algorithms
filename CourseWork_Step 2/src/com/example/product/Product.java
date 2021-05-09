package com.example.product;

public class Product {
    
   private  int stock;
   private String productCode;
   private  String productName;

    public Product(int stock, String productCode, String productName) {
        this.stock = stock;
        this.productCode = productCode;
        this .productName = productName;
    }

    public String getProductInformation() {
        return "\nPRODUCT CODE: " + this.productCode + " PRODUCT NAME: " + this.productName + " QUANTITY IN STOCK: " + this.stock;
    }

    public String getName() {
        return productName;
    }

    public String getCode() {
        return productCode;
    }
}
