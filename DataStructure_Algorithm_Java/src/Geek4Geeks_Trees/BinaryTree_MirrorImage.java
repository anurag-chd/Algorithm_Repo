package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class BinaryTree_MirrorImage {
	public static void main(String args[]){
		GenTreeNode<Character> root = new GenTreeNode<Character>('a');
		root.setLeft_child(new GenTreeNode('b'));
		root.setRight_child(new GenTreeNode('c'));
		root.getLeft_child().setLeft_child(new GenTreeNode('d'));
		root.getLeft_child().setRight_child(new GenTreeNode('e'));
		root.getRight_child().setRight_child(new GenTreeNode('f'));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode('g'));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode('h'));
		
		printInOrder(root);
		
		root = mirrorImage(root);
		System.out.println();
		
		printInOrder(root);
	}
	
	public static void printInOrder(GenTreeNode  root){
		if(root == null)
			return;
		printInOrder(root.getLeft_child());
		System.out.print(root.getData()+" ,");
		printInOrder(root.getRight_child());
	}
	
	public static GenTreeNode mirrorImage(GenTreeNode root){
		if(root == null)
			return null;
		root.setLeft_child(mirrorImage(root.getLeft_child()));
		root.setRight_child(mirrorImage(root.getRight_child()));
		
		GenTreeNode temp = root.getLeft_child();
		root.setLeft_child(root.getRight_child());
		root.setRight_child(temp);
		
		return root;
	}
}
