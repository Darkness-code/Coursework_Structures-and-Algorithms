package com.example.linkedlist;

import com.example.product.Product;

public class SimpleListNode {

    private SimpleListNode next;
    private final Product data;

    public SimpleListNode(Product data) {
        this.data = data;
        this.next = null;
    }

    public void add(Product p) {
        if (this.next == null) {
            this.next = new SimpleListNode(p);
        } else {
            this.next.add(p);
        }
    }

    public String getInformation() {
        return data.getProductInformation();
    }

    public SimpleListNode getNext() {
        return next;
    }
    
    public SimpleListNode setNext(SimpleListNode next) {
        return this.next=next;
    }

    public String getName() {
        return this.data.getName();
    }

    public String getCode() {
        return this.data.getCode();
    }

    public Product getData() {
        return data;
    }

}
