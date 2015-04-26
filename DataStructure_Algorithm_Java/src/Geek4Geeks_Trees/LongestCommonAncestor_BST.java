package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class LongestCommonAncestor_BST {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(7));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		
		GenTreeNode<Integer> node1 = root.getLeft_child().getLeft_child();
		GenTreeNode<Integer> node2 = root.getLeft_child().getRight_child().getRight_child();
		
		GenTreeNode <Integer> temp = findLCA(node1,node2,root);
		System.out.println(temp.getData());
	}
	
	public static GenTreeNode<Integer> findLCA(GenTreeNode<Integer> node1,GenTreeNode<Integer> node2,GenTreeNode<Integer> root){
		if(root == null)
			return null;
		if(root.getData() > node1.getData() && root.getData() > node2.getData())
			return findLCA(node1,node2,root.getLeft_child());
		else if(root.getData() <= node1.getData() && root.getData() <= node2.getData())
			return findLCA(node1,node2,root.getRight_child());
		else
			return root;
	}

}
