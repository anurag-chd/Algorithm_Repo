package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class Root_To_Leaf_Sum {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(7));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		
		System.out.println("Sum to 35 path exist "+ findSum(root,31));
	}
	public static boolean findSum(GenTreeNode<Integer> root, int sum){
		if(root == null){
			return false;
		}
		sum = sum -root.getData();
		if(sum == 0 && root.getLeft_child() == null && root.getRight_child() == null)
			return true;
		return (findSum(root.getLeft_child(),sum) || findSum(root.getRight_child(),sum));
	}
}
