package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class KthSmallest_BST {
	static int count = 1;
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(7));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		
		//int result = ksmallestnum(root,4,1);
		ksmallestnum(root,4);
		
	}
	
	public static void ksmallestnum(GenTreeNode<Integer> root, int k){
		if(root == null){
			return ;
		}
		ksmallestnum(root.getLeft_child(),4);
		if(count == k){
			
			System.out.println(root.getData());
			count++;
			
		}
		else if(count != k){
			//System.out.println(count);
			count++;
		}
		ksmallestnum(root.getRight_child(),4);
		
	}
}
