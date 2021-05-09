package com.example.binarysearchtree;


public class BinaryTreeNode extends Exceptions  {

private BinaryTreeNode left;
private 	BinaryTreeNode right;
private Comparable petType;
	
	public BinaryTreeNode(Comparable petType) {
		
		left = null;
		right = null;
		this.petType = petType;
	}
	
	 public Comparable getPetType(){
	        return petType;
	   }
	 
	   public void setPetType(Comparable petType) {
	        this.petType=petType;
	   }
	   
	   public BinaryTreeNode  getLeft(){
	       return left;
	   }
	   
	   public void setLeft(BinaryTreeNode left) {
	        this.left=left;
	   }
	   
	   public BinaryTreeNode getRight(){
	       return right;
	   }
	
	   public void setRight(BinaryTreeNode right) {
	        this.right=right;
	   }
	 
	   
    public void insert(BinaryTreeNode newNode,BinaryTreeNode current) throws Exceptions.NotUniqueException {
	           /* Algorithm
	               if new object matches current object then
	                   // attempt to add a duplicate
	                   throw not unique exception
	               end if
	               if new object is less than the current object then
	                   if current node does not have a left subtree then
	                       make left of current the new node
	                   else
	                       insert the new node in the left subtree
	                   end if
	               else
	                   if current node does not have a right subtree then
	                       make right of current the new node
	                   else
	                       insert the new node in the right subtree
	                   end if
	               end if
	            end if
	            */
	           if (newNode.petType.compareTo(current.petType) == 0)
	               throw new NotUniqueException(); 
	           if (newNode.petType.compareTo(current.petType) < 0) {
	               if (current.left == null) {
	                   current.left = newNode;
	               } else {
	                   insert(newNode,current.left);
	               }
	           } else if (current.right == null) {
	               current.right = newNode;
	           } else {
	               this.insert(newNode,current.right);
	           }
}

  
 
}
  
