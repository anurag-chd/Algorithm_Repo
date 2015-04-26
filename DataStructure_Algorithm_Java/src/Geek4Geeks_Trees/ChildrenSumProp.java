package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class ChildrenSumProp {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(8));
		root.setRight_child(new GenTreeNode(2));
		root.getLeft_child().setLeft_child(new GenTreeNode(3));
		root.getLeft_child().setRight_child(new GenTreeNode(5));
		root.getRight_child().setRight_child(new GenTreeNode(2));
		
		
		System.out.println("The tree is sum tree" + isChildSum(root));
	}
	
	public static boolean isChildSum(GenTreeNode<Integer> root){
		if(root == null){
			return true;
		}
		boolean left = isChildSum(root.getLeft_child());
		int sum =0;
		if(root.getLeft_child() != null)
			sum = sum + root.getLeft_child().getData();
		if(root.getRight_child() != null)
			sum = sum + root.getRight_child().getData();
		if(sum == root.getData())
			return true;
		else if(sum != root.getData())
			return false;
		boolean right = isChildSum(root.getRight_child());
		
		if(left == false || right == false)
			return false;
		else{
			return true;
		}
	}

}
