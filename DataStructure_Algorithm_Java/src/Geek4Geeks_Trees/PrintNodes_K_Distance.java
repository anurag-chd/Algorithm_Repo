package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class PrintNodes_K_Distance {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(7));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		
		printKLevel(root , 3);
	}
	
	public static void printKLevel(GenTreeNode<Integer> root , int level){
		if(root == null || level < 0)
			return;
		level--;
		printKLevel(root.getLeft_child(),level);
		printKLevel(root.getRight_child(),level);
		if(level == 0){
			System.out.print(root.getData()+ " ,");
		}
		
		
	}
}
