package Vmware;

import Basics.GenTreeNode;

public class TreeSubtree {
	public static void main(String args[]){
		GenTreeNode<Character> root1 = new GenTreeNode<Character>('a');
		root1.setLeft_child(new GenTreeNode<Character>('b'));
		root1.setRight_child(new GenTreeNode<Character>('c'));
		root1.getLeft_child().setLeft_child(new GenTreeNode<Character>('d'));
		root1.getLeft_child().getLeft_child().setLeft_child(new GenTreeNode<Character>('e'));
		root1.getRight_child().setLeft_child(new GenTreeNode<Character>('f'));
		root1.getLeft_child().setRight_child(new GenTreeNode<Character>('g'));
		
		GenTreeNode<Character> root2 = new GenTreeNode<Character>('b');
		root2.setLeft_child(new GenTreeNode<Character>('d'));
		root2.setRight_child(new GenTreeNode<Character>('g'));
		root2.getLeft_child().setLeft_child(new GenTreeNode<Character>('e'));
		
		if(findSubTree(root1, root2)){
			System.out.println("Is a Subtree");
		}
		else{
			System.out.println("Not a subtree");
		}
	}
	
	public static boolean findSubTree(GenTreeNode<Character> root1,GenTreeNode<Character> root2){
		if(root2 == null){
			return true;
		}
		return searchCommonRoot(root1,root2);
		
	}
	public static boolean searchCommonRoot(GenTreeNode<Character> root1,GenTreeNode<Character> root2){
		if(root1 == null)
			return false;
		else{
			if(root1.getData() == root2.getData()){
				if(coverTree(root1,root2))
					return true;
			}
				
			
		return (searchCommonRoot(root1.getLeft_child(), root2) || searchCommonRoot(root1.getRight_child(), root2));		
		}
		
		
	}
	
	public static boolean coverTree(GenTreeNode<Character> root1,GenTreeNode<Character> root2){
		if(root1 == null && root2 == null)
			return true;
		else if(root1 == null || root2 == null)
			return false;
		else if(root1.getData() != root2.getData())
			return false;
		else{
			return (coverTree(root1.getLeft_child(),root2.getLeft_child()) && coverTree(root1.getRight_child(),root2.getRight_child()));
		}
	}
	
}
