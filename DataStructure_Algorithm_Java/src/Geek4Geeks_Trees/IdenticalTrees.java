package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class IdenticalTrees {
	public static void main(String args[]){
		// tree 1
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(7));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		
		// tree 2
		GenTreeNode<Integer> root1 = new GenTreeNode<Integer>(10);
		root1.setLeft_child(new GenTreeNode(6));
		root1.setRight_child(new GenTreeNode(12));
		root1.getLeft_child().setLeft_child(new GenTreeNode(4));
		root1.getLeft_child().setRight_child(new GenTreeNode(8));
		root1.getRight_child().setRight_child(new GenTreeNode(16));
		root1.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(7));
		root1.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		
		System.out.println("Both trees are identical "+ isIdentical(root,root1));
	}
	
	public static boolean isIdentical(GenTreeNode<Integer> root1, GenTreeNode<Integer> root2){
		if(root1 == null && root2 == null){
			return true;
		}
		if(root1 != null && root2 != null){
			return (root1.getData() == root2.getData() && isIdentical(root1.getLeft_child(), root2.getLeft_child()) && isIdentical(root1.getRight_child(), root2.getRight_child()) );
		}
		return false;
	}

}
