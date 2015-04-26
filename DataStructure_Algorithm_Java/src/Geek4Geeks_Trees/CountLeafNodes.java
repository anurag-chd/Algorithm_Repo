package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class CountLeafNodes {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(7));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		
		int count = countLeaf(root);
		System.out.println(count);
	}
	
	public static int countLeaf(GenTreeNode<Integer> root){
		if(root == null)
			return 0;
		if(root.getLeft_child() == null && root.getRight_child() == null)
			return 1;
		
		return(countLeaf(root.getLeft_child()) + countLeaf(root.getLeft_child()));
	}
}
