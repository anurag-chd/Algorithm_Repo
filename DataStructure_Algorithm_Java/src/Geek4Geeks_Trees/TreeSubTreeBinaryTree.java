package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class TreeSubTreeBinaryTree {
	static boolean flag = false;
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(7));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		
		GenTreeNode<Integer> root1 = new GenTreeNode<Integer>(8);
		root1.setLeft_child(new GenTreeNode(7));
		root1.setRight_child(new GenTreeNode(9));
		
		System.out.println("Tree 2 is Sub tree of Tree 1 "+ checkSubTree(root, root1));
	}
	
	public static boolean checkSubTree(GenTreeNode<Integer> root1, GenTreeNode<Integer> root2){
		
		if(root2 == null)
			return true;
		if(root1 == null)
			return false;
		
		GenTreeNode<Integer> temp = getMatchingRoot(root1, root2);
		
		return checkEqualTree(temp, root2);
		
	}
	
	public static boolean checkEqualTree(GenTreeNode<Integer> root1, GenTreeNode<Integer> root2){
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null && root2 != null || root1 != null && root2 == null)
			return false;
		if(root1.getData() != root2.getData())
			return false;
		boolean left = checkEqualTree(root1.getLeft_child(),root2.getLeft_child());
		boolean right = checkEqualTree(root1.getRight_child(),root2.getRight_child());
		
		if(left == false || right == false)
			return false;
		else{
			return true;
		}
	}
	
	
	public static GenTreeNode<Integer> getMatchingRoot(GenTreeNode<Integer> root1, GenTreeNode<Integer> root2){
		if(root1 == null)
			return null;
		if(root1.getData() == root2.getData()){
			System.out.println(root1.getData());
			return root1;
		}
			
		
		GenTreeNode<Integer> left = getMatchingRoot(root1.getLeft_child(),root2);
		GenTreeNode<Integer> right = getMatchingRoot(root1.getRight_child(),root2);
		
		if(left != null)
			return left;
		if(right != null)
			return right;
		else
			return null;
		
	}
}
