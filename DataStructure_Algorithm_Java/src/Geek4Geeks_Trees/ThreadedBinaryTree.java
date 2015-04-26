package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class ThreadedBinaryTree {
	public static void main(String args[]){
		GenTreeNode<Character> root = new GenTreeNode<Character>('a');
		root.setLeft_child(new GenTreeNode('b'));
		root.setRight_child(new GenTreeNode('c'));
		root.getLeft_child().setLeft_child(new GenTreeNode('d'));
		root.getLeft_child().setRight_child(new GenTreeNode('e'));
		root.getRight_child().setRight_child(new GenTreeNode('f'));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode('g'));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode('h'));
		
		printTree(root);
	}
	
	public static void printTree(GenTreeNode root){
		if(root == null)
			return;
		GenTreeNode current,prev;
		current = root;
		while(current!=null){
			if(current.getLeft_child() == null){
				System.out.println(current.getData());
				current = current.getRight_child();
			}
			
			else{
				prev = current.getLeft_child();
				while(prev.getRight_child()!=null && prev.getRight_child()!= current){
					prev = prev.getRight_child();
				}
				if(prev.getRight_child() == null){
					prev.setRight_child(current);
					current = current.getLeft_child();
				}
				else{
					prev.setRight_child(null);
					System.out.println(current.getData());
					current = current.getRight_child();
				}
			}
		}
		
	}
}
