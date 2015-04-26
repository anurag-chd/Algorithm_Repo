package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class DeleteTree_PostOrder {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(7));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		
		root  = deleteTree(root);
		if(root== null)
			System.out.println("The tree is deleted");
		else{
			System.out.println("The tree is still there" + root.getData());
		}
	}
	
	public static GenTreeNode<Integer> deleteTree(GenTreeNode<Integer> root){
		if(root == null)
			return root;
		deleteTree(root.getLeft_child());
		deleteTree(root.getRight_child());
		root = null;
		return root;
		
	}
}
