package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class Diameter_BinaryTree {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(8));
		root.setRight_child(new GenTreeNode(2));
		root.getLeft_child().setLeft_child(new GenTreeNode(3));
		root.getLeft_child().setRight_child(new GenTreeNode(5));
		root.getRight_child().setRight_child(new GenTreeNode(2));
		
		System.out.println("The max diameter " + calDiameter(root));
	}
	
	public static int calDiameter(GenTreeNode<Integer> root){
		if(root == null){
			return 0;
		}
		
		int lheight = calHeight(root.getLeft_child());
		int rheight = calHeight(root.getRight_child());
		
		
		int ldiameter = calDiameter(root.getLeft_child());
		System.out.println("lheight "+lheight+" rheight " +rheight +" ldiameter "+ ldiameter);
		int rdiameter = calDiameter(root.getRight_child());
		System.out.println("lheight "+lheight+" rheight " +rheight +" ldiameter "+ ldiameter+" rdiameter " +rdiameter);
		
		return Math.max(lheight + rheight +1, Math.max(ldiameter, rdiameter));
	}
	
	
	public static int calHeight(GenTreeNode<Integer> root){
		if(root == null)
			return 0;
		return (1 + Math.max(calHeight(root.getLeft_child()), calHeight(root.getRight_child())));
	}
}
