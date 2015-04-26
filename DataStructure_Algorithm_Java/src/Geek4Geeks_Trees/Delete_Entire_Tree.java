package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class Delete_Entire_Tree {
	public static void main(String args[]){
		GenTreeNode<Character> root = new GenTreeNode<Character>('a');
		root.setLeft_child(new GenTreeNode('b'));
		root.setRight_child(new GenTreeNode('c'));
		root.getLeft_child().setLeft_child(new GenTreeNode('d'));
		root.getLeft_child().setRight_child(new GenTreeNode('e'));
		root.getRight_child().setRight_child(new GenTreeNode('f'));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode('g'));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode('h'));
		
		root = delTree(root);
		if(root == null){
			System.out.println("tree deleted");
		}
		else{
			System.out.println("chutiap");
		}
		//System.out.println(root.getData());
	}
	
	public static GenTreeNode<Character> delTree(GenTreeNode<Character> root){
		if(root == null){
			return null;
		}
		else{
			root.setLeft_child(delTree(root.getLeft_child()));
			root.setRight_child(delTree(root.getRight_child()));
			System.out.println(root.getData());
			root = null;
				
			return root;
			/*if(root.getLeft_child() != null){
				count = delTree(root.getLeft_child(),count);
				
			}
				
			if(root.getRight_child() != null){
				count = delTree(root.getRight_child(),count);
				
			}
			if(root.getLeft_child() == null && root.getRight_child() == null){
				root = null;
				count++;
			}
				
			return count;
	*/	}
	}
}
