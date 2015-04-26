package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class SizeofTree {
	public static void main (String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(7));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		
		int res = calSize(root);
		System.out.println(res);
	}
	
	public static int calSize(GenTreeNode<Integer> root){
		if(root == null){
			return 0;
		}
		return 1 + calSize(root.getLeft_child()) + calSize(root.getRight_child()); 
	}
}
