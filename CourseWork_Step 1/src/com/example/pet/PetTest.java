package com.example.pet;

import com.example.binarysearchtree.BinaryTree;
import com.example.binarysearchtree.Exceptions;
import com.example.binarysearchtree.Exceptions.NotFoundException;

public class PetTest {

		public static void main(String[] args) {
				String petName;
				String searchedPetType;
			        String displayedPetType;
			        String deletePetType;
			        String sortedTree;
			        
				int option;
				 
				BinaryTree petTree = new BinaryTree();

				do {
					        System.out.println("--------------------------------------------------------");
					        System.out.println("\nPress 0 to quit");
						System.out.println("Press 1 to add a pet type");
						System.out.println("Press 2 to find if we provide products for a particular pet type");
						System.out.println("Press 3 to display a specific pet type");
						System.out.println("Press 4 to remove a specific pet type");
						System.out.println("Press 5 to display all pet types we provide products in alphabetical order");
						System.out.println("\n--------------------------------------------------------\n");

						option = Input.getInteger("Enter your option: ");
						switch (option) {

						case 0: System.out.println("Program has been terminated!\nWe hope you come back soon :)");
								break;
								
						case 1: petName = Input.getString("Enter pet type name: ");
								Pet petObject = new Pet(petName, null);
								try {     petTree.insertNode(petObject.getName());
								              System.out.println("\n*Successfully inserted!*");
								} catch (Exceptions.NotUniqueException e) {
										System.out.println("\n*This pet type already exists in the system!* \n*Please enter your option again below*");
								}
								break;
								
						case 2 : searchedPetType= Input.getString("Enter pet type name to check if products are available: ");
						              //  Pet searchedPetObj = new Pet(searchedPetType, null);
								try{
								       petTree.find(searchedPetType);
								       System.out.println("\nProducts are available for " + searchedPetType);
								}
								catch(Exceptions.NotFoundException e){
								    	System.out.println("\n*This pet type doesnt exist yet so we dont offer products for now*");
								}
								break;
								
						case 3:  displayedPetType = Input.getString("Enter a specific pet type to be displayed: ");
							 	//Pet displayedPetObj = new Pet(displayedPetType, null);
							 	try{
								       petTree.find(displayedPetType);
								       System.out.println("\nThe pet type you asked to be displayed: >>>* " + displayedPetType + " *<<<");
								}
								catch(Exceptions.NotFoundException e){
								    	System.out.println("\n*This pet type you asked to be displayed doesnt exist*");
								}
								break;	
								
						case 4:	deletePetType = Input.getString("Enter a specific pet type to be deleted: ");
						    try {
									petTree.remove(deletePetType);
									System.out.println("\n*Successfully removed!*");
						    		} catch (Exceptions.NotFoundException e) {
							
						    		    System.out.println("\n*The pet type you asked to be removed doesnt exist*");
						    		}
						    		break;
								
						case 5: System.out.println("\nDisplayed pet types in alphabetical order: >>>* " + petTree.getInOrder(petTree.getRoot())+ "*<<<");
						    		break;
						    
						default: 
								System.out.println("Invalid menu option!");
								System.out.println("Try again");
								break;

								}

				} while (option != 0);

		}

}