package Vmware;

import Basics.GenTreeNode;

public class CommonAncestorTree {
	public static void main(String args[]){
		GenTreeNode<Character> root = new GenTreeNode<Character>('a');
		root.setLeft_child(new GenTreeNode<Character>('b'));
		root.setRight_child(new GenTreeNode<Character>('c'));
		root.getLeft_child().setLeft_child(new GenTreeNode<Character>('d'));
		root.getLeft_child().getLeft_child().setLeft_child(new GenTreeNode<Character>('e'));
		root.getRight_child().setLeft_child(new GenTreeNode<Character>('f'));
		root.getLeft_child().setRight_child(new GenTreeNode<Character>('g'));
		GenTreeNode<Character> ancestor = find(root,root.getLeft_child().getLeft_child().getLeft_child(), root.getRight_child().getLeft_child());
	}
	
	public static GenTreeNode<Character> find(GenTreeNode<Character> root, GenTreeNode<Character> a, GenTreeNode<Character> b){
		if(root == null || a == null || b == null)
			return null;
		if(cover(root.getLeft_child(),a) && cover(root.getLeft_child(),b)){
			return find(root.getLeft_child(),a,b);
		}
		else if(cover(root.getRight_child(),a) && cover(root.getRight_child(),b))
			return find(root.getRight_child(),a,b);
		
		else
			return root;
	}
	
	public static boolean cover(GenTreeNode root,GenTreeNode b ){
		if(root == null)
			return false;
		else{
			if(root == b)
				return true;
			else
				return (cover(root.getLeft_child(),b) || cover(root.getRight_child(),b));
		}
	}
	
	
	
}
