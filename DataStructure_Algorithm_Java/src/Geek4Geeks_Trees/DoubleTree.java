package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class DoubleTree {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode<Integer>(6));
		root.setRight_child(new GenTreeNode<Integer>(12));
		root.getLeft_child().setLeft_child(new GenTreeNode<Integer>(4));
		root.getLeft_child().setRight_child(new GenTreeNode<Integer>(8));
		
		printInorder(root);
		
		root = convertDoubleTree(root);
		System.out.println();
		printInorder(root);
	}
	
	public static GenTreeNode<Integer> convertDoubleTree(GenTreeNode<Integer> root){
		if(root == null){
			return root;
		}
		root.setLeft_child(convertDoubleTree(root.getLeft_child()));
		root.setRight_child(convertDoubleTree(root.getRight_child()));
		
		GenTreeNode<Integer> dup = new GenTreeNode<Integer>(root.getData());
		dup.setLeft_child(root.getLeft_child());
		root.setLeft_child(dup);
		
		return root;
	}
	
	public static void printInorder(GenTreeNode<Integer> root){
		if(root == null)
			return;
		printInorder(root.getLeft_child());
		System.out.print(root.getData()+" ,");
		printInorder(root.getRight_child());
	}
}
