package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class InorderTraversal_WithoutRecurssion {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(8));
		root.setRight_child(new GenTreeNode(2));
		root.getLeft_child().setLeft_child(new GenTreeNode(3));
		root.getLeft_child().setRight_child(new GenTreeNode(5));
		root.getRight_child().setRight_child(new GenTreeNode(2));
		
		printInorder(root);
		System.out.println();
		
		printWORecurr(root);
	}
	
	public static void printInorder(GenTreeNode<Integer> root){
		if(root == null)
			return;
		printInorder(root.getLeft_child());
		System.out.print(root.getData()+" ,");
		printInorder(root.getRight_child());
	}
	
	public static void printWORecurr(GenTreeNode<Integer> root){
		while(root != null){
			if(root.getLeft_child() == null){
				System.out.print(root.getData()+ " ,");
				root = root.getRight_child();
			}
			else{
				GenTreeNode<Integer> lRightmost = getRightMost(root);
				if(lRightmost.getRight_child() == root){
					
					System.out.print(root.getData()+" ,");
					root = root.getRight_child();
				}
				else{
					lRightmost.setRight_child(root);
					root= root.getLeft_child();
				}
				
			}
		}
		
	}
	
	public static GenTreeNode<Integer> getRightMost(GenTreeNode<Integer> root){
		GenTreeNode<Integer> temp = root.getLeft_child();
		while(temp.getRight_child()!=null && temp.getRight_child() != root){
			temp = temp.getRight_child();
		}
		return temp;
	}
}
