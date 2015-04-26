package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class BoundaryTraversal_BinaryTree {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(7));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		
		printBoundaryElements(root);
	}
	
	public static void printBoundaryElements(GenTreeNode<Integer> root){
		System.out.print(root.getData()+"," );
		printLeftSide(root.getLeft_child());
		printLeaves(root);
		printRightSide(root.getRight_child());
	}
	
	public static void printLeaves(GenTreeNode<Integer> root){
		if(root == null)
			return;
		
		printLeaves(root.getLeft_child());
		if(root.getLeft_child() == null && root.getRight_child() == null){
			System.out.print(" " + root.getData()+",");
		}
		printLeaves(root.getRight_child());
	}
	
	public static void printLeftSide(GenTreeNode<Integer> root){
		if(root == null){
			return;
		}
		while(root.getLeft_child() != null){
			System.out.print(" "+root.getData()+",");
			root = root.getLeft_child();
		}
		if(root.getRight_child() != null)
			System.out.print(" "+root.getData());
	}
	
	public static void printRightSide(GenTreeNode<Integer> root){
		if(root == null){
			return;
		}
		while(root.getRight_child() != null){
			System.out.print(" "+root.getData()+",");
			root = root.getRight_child();
		}
		if(root.getLeft_child() != null)
			System.out.print(" "+root.getData());
	}
}
