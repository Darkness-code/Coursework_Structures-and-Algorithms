package com.example.product;

import com.example.linkedlist.SimpleLinkedList;

public class ProductTest {

    public static void main(String[] args) {
	
	    String productName, productCode;
	    String searchedProduct;
	    int option,stock;
	    
	    SimpleLinkedList linkedList = new SimpleLinkedList();
 

	    				do {
						        System.out.println("--------------------------------------------------------");
						        System.out.println("\nPress 0 to quit");
							System.out.println("Press 1 to add a product");
							System.out.println("Press 2 to find a product ");
							System.out.println("Press 3 to remove a product ");
							System.out.println("Press 4 to display all the products ");
							System.out.println("\n--------------------------------------------------------\n");

							option = Input.getInteger("Enter your option: ");
							switch (option) {

							case 0: System.out.println("Program has been terminated!\nWe hope you come back soon :)");
									break;
									
							case 1: productName = Input.getString("Enter the product name: ");
								       productCode = Input.getString("Enter the product code: ");
								       stock = Input.getInteger("Enter the quantity in stock: ");
								       
								       Product product = new Product(stock,productCode, productName);
								       linkedList.addProducts(product);
								
									break;
									
							case 2 : searchedProduct = Input.getString("Enter the product name or product code: ");
									linkedList.findProduct(searchedProduct, linkedList.getHead());
									break;
									
							case 3: searchedProduct= Input.getString("Enter the product code of the product to be removed:  ");
									linkedList.deleteNode(searchedProduct);
									System.out.println("\n*Product has been deleted successfully!*");
									break;	
									
							case 4:	System.out.println("All products displayed below: ");
									linkedList.displayProducts(linkedList.getHead());
									
							    		break;
							
							    
							default: 
									System.out.println("Invalid menu option!");
									System.out.println("Try again");
									break;

									}

					} while (option != 0);

			}
    }


