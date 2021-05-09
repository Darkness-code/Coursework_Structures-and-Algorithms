package com.example.binarysearchtree;

import com.example.pet.Pet;

public class BinaryTree extends Exceptions {

		private BinaryTreeNode root;
		private BinaryTreeNode current; 
		private BinaryTreeNode parent; 
		
		public BinaryTree() {
				root = null;
		}

		public BinaryTreeNode getRoot() {
				return root;
		}

		    public BinaryTreeNode getCurrent() {
			return current;
		    }
		
		    public void insertNode(Comparable insertPet) throws NotUniqueException {
				/*
				 * Algorithm create a new tree node add the object to the new node if tree is
				 * empty then make root refer to the new node else insert the new node in the
				 * tree 
				 */
				BinaryTreeNode newNode = new BinaryTreeNode(insertPet);
				if (root == null)
						root = newNode;
				else
						newNode.insert(newNode, root);
		}

		// returns the object removed
		// public abstract Comparable remove(Comparable object) throws
		// NotFoundException;
		 

		public String find(String searchedPet) throws NotFoundException {
		        return this.find(searchedPet,this.root);
		    }

		    private String find(String searchedPet, BinaryTreeNode current) throws NotFoundException{
			String foundPet;
		        if (current != null) {
		            if (searchedPet.compareTo((String) current.getPetType()) == 0) {
		                this.current=current;
		                foundPet = (String) current.getPetType();
		            } else{
		                this.parent=current;
		                if (searchedPet.compareTo((String) current.getPetType()) < 0) {
		                    foundPet = this.find(searchedPet,current.getLeft());
		                } else {
		                    foundPet = this.find(searchedPet,current.getRight());
		                }
		            }
		        } else{
		            throw new NotFoundException();
		        }
		        return foundPet;
		    
		   }

		    public Comparable remove(Comparable object) throws NotFoundException {
		        // sets up parent and current
		        Comparable removedObject=this.find((String) object);
		        if (this.current.getLeft() == null && this.current.getRight() == null) {
		            this.replaceNode(null);
		        } else if (this.current.getLeft() != null && this.current.getRight() == null) {
		            this.replaceNode(this.current.getLeft());
		            this.current.setLeft(null);
		        } else if (this.current.getLeft() == null && this.current.getRight() != null) {
		            this.replaceNode(this.current.getRight());
		            this.current.setRight(null);
		        } else {
		            this.replaceWithNextLargest(this.current, this.current, this.current.getRight());
		        }
		        return removedObject;
		    }

		 

		    private void replaceNode(BinaryTreeNode replacement) {
		        /* algorithm
		            if current is root then 
		                set root to replacement node
		            else
		                if current is the root of the left subtree of parent then
		                    set parent's left subtree to replacement node
		                else
		                    set parent's right subtree to replacement node
		                end if
		            end if
		            set current object to null
		         */
		        if (this.current == this.root) // removing root
		        {
		            this.root = replacement;
		        } else if (this.current == this.parent.getLeft()) {
		            this.parent.setLeft(replacement);
		        } else {
		            this.parent.setRight(replacement);
		            }
		        this.current.setPetType(null);
		    }

		 

		    private void replaceWithNextLargest(BinaryTreeNode nodeForDeletion, BinaryTreeNode parent, BinaryTreeNode current) {
		        /* Algorithm
		            if current does not have a left subtree then
		                copy the current object into the node for deletion
		                if parent matches the node for deletion then
		                    set parent's right subtree to be current's right subtree
		                else
		                    set parent's left subtree to be current's right subtree
		                end if
		                clear the current node
		            else
		                replace node for deletion with the next largest in current's left subtree
		            end if
		         */
		        if (current.getLeft()== null) {
		            nodeForDeletion.setPetType(current.getPetType());
		            if (parent == nodeForDeletion) {
		                parent.setRight(current.getRight());
		            } else {
		                parent.setLeft(current.getRight());
		            }
		            current.setPetType(null); 
		            current.setRight(null);
		        } else {
		            this.replaceWithNextLargest(nodeForDeletion, current, current.getLeft());
		        }
		    }

		    public String getInOrder(BinaryTreeNode current) {
		        String inOrderDetails = new String();
		        if (current != null) {
		            inOrderDetails += this.getInOrder(current.getLeft());
		            inOrderDetails += current.getPetType() + "  ";
		            inOrderDetails += this.getInOrder(current.getRight());
		        }
		        return inOrderDetails;
		    }

		

		
}
