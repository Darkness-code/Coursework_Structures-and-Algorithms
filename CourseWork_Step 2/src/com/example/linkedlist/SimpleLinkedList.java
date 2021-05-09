package com.example.linkedlist;

import java.util.ArrayList;

import com.example.product.Product;

public class SimpleLinkedList {

    private SimpleListNode head;

  
    public SimpleLinkedList() {
        this.head = null;
    }

    public SimpleListNode getHead() {
        return head;
    }

    public void addProducts(Product p) {
        int counter = 0;
        
        if (head == null) {
            head = new SimpleListNode(p);
        }

        SimpleListNode current = head;

        while (current != null) {
            if (current.getCode().equals(p.getCode())) {
                counter++;
            }
            current = current.getNext();
        }

        if (counter == 0) {
            head.add(p);
        }
        else {
            System.out.println("\n*Inserted Successfully!*");
        }
    }

    public void displayProducts(SimpleListNode head) {
        if (head == null) {
            System.out.println("\n*There are no products in the system!*");
            return;
        }
        SimpleListNode current = head;

        while (current != null) {
            System.out.println(current.getInformation());
            current = current.getNext();
        }
    }

    public void findProduct(String searchTerm, SimpleListNode head) {

 
        ArrayList<Product> searchResults = new ArrayList<>(); 

        if (head == null) {
            System.out.println("\n*List is empty!*");
            return;
        }
        SimpleListNode current = head;

        while (current != null) {
            if (current.getName().equals(searchTerm) || current.getCode().equals(searchTerm)) {
                searchResults.add(current.getData());
            }
            current = current.getNext();
        }

      
        if (searchResults.size() == 0) {
            System.out.println("\n*No products have been found!*");
        }
        else {
            for (Product searchResult : searchResults) {
                System.out.println(searchResult.getProductInformation());
            }
        }
    }

    public void deleteNode(String code) {
        if (head == null) return;

        if (head.getCode().equals(code)) {
            head = head.getNext();
            return;
        }

        SimpleListNode current = head;

        while (current != null) {
            if (current.getNext().getCode().equals(code)) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }
    }

 

}

 


