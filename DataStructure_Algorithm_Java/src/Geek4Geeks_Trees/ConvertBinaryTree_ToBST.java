package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class ConvertBinaryTree_ToBST {
	public static GenTreeNode<Integer> parent = null;
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(15));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		System.out.println("Print the binary tree ");
		printTree(root);
		
		convertBinaryTree(root);
		
		System.out.println("Print the bST ");
		printTree(root);
		
	}
	public static void printTree(GenTreeNode<Integer> root){
		if(root == null)
			return;
		printTree(root.getLeft_child());
		System.out.print(root.getData()+" ,");
		printTree(root.getRight_child());
			
	}
	
	public static void convertBinaryTree(GenTreeNode<Integer> root){
		if(root == null){
			return;
		}
		convertBinaryTree(root.getLeft_child());
		if(parent != null){
			if(parent.getData() > root.getData()){
				int temp = root.getData();
				root.setData(parent.getData());
				parent.setData(temp);
			}
		}
		parent = root;
		convertBinaryTree(root.getRight_child());
		
	}
}
