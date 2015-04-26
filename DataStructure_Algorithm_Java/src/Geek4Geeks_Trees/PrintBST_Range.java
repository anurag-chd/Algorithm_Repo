package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class PrintBST_Range {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(7));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		
		printNodeInRange(root,8,12);
			
		
	}
	
	public static void printNodeInRange(GenTreeNode<Integer> root, int x, int y){
		if(root == null)
			return;
		printNodeInRange(root.getLeft_child(),x,y);
		if(root.getData() >= x && root.getData() <= y)
			System.out.print(root.getData() + ", ");
		printNodeInRange(root.getRight_child(),x,y);
	}
}
