package com.example.pet;

public class Pet{

    private Pet linkedProducts; //in this step it isnt used to link products to a pet type, it will be used in step 3.
    private String name;

    public Pet(String name, Pet linkedProducts) {

	this.linkedProducts = linkedProducts;
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public String toString() {
	return "\nPET TYPE:" + name  + " PRODUCTS AVAILABLE:" + linkedProducts;
	
    }

   
}
