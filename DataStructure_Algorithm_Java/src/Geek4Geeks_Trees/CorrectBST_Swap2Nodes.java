package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class CorrectBST_Swap2Nodes {
	static GenTreeNode<Integer> parent = null;
	static GenTreeNode<Integer> ptr1 = null;
	static GenTreeNode<Integer> ptr2 = null;
	
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(5));
		root.setRight_child(new GenTreeNode(8));
		root.getLeft_child().setLeft_child(new GenTreeNode(2));
		root.getLeft_child().setRight_child(new GenTreeNode(20));
		
		printTree(root);
		correctTree(root);
		System.out.println();
		printTree(root);
	}
	
	public static void correctTree(GenTreeNode<Integer> root){
		if(root == null)
			return;
		swapWrongChild(root);
		int temp = ptr1.getData();
		ptr1.setData(ptr2.getData());
		ptr2.setData(temp);
		
	}
	
	public static void swapWrongChild(GenTreeNode<Integer> root){
		if(root == null)
			return;
		
		swapWrongChild(root.getLeft_child());
		
		if(parent != null){
			if(parent.getData() > root.getData()){
				if(ptr1 == null)
					ptr1 = parent;
				else
					ptr2 = root;
			}
		}
		parent = root;
		swapWrongChild(root.getRight_child());
	}
	
	
	
	public static void printTree(GenTreeNode<Integer> root){
		if(root == null)
			return;
		printTree(root.getLeft_child());
		System.out.print(root.getData()+" ,");
		printTree(root.getRight_child());
			
	}
	
}
