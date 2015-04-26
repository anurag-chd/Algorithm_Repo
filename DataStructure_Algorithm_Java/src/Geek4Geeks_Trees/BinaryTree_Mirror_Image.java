package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class BinaryTree_Mirror_Image {
	public static void main(String args[]){
		GenTreeNode<Character> root = new GenTreeNode<Character>('a');
		root.setLeft_child(new GenTreeNode('b'));
		root.setRight_child(new GenTreeNode('c'));
		root.getLeft_child().setLeft_child(new GenTreeNode('d'));
		root.getLeft_child().setRight_child(new GenTreeNode('e'));
		root.getRight_child().setRight_child(new GenTreeNode('f'));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode('g'));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode('h'));
		
		printInorder(root);
		root = mirrorOrder(root);
		System.out.println();
		printInorder(root);
	}
	
	public static void printInorder(GenTreeNode<Character> root){
		if(root == null)
			return;
		printInorder(root.getLeft_child());
		System.out.print(root.getData()+" ,");
		printInorder(root.getRight_child());
		return;
	}
	
	public static GenTreeNode<Character> mirrorOrder(GenTreeNode<Character> root){
		if(root == null){
			return null;
		}
		else{
			root.setLeft_child(mirrorOrder(root.getLeft_child()));
			root.setRight_child(mirrorOrder(root.getRight_child()));
			GenTreeNode<Character> temp = root.getLeft_child();
			root.setLeft_child(root.getRight_child());
			root.setRight_child(temp);
			return root;
			
		}
	}
}
