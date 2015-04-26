package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class FoldableBinaryTree {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode<Integer>(7));
		root.setRight_child(new GenTreeNode<Integer>(15));
		root.getRight_child().setLeft_child(new GenTreeNode<Integer>(11));
		root.getLeft_child().setRight_child(new GenTreeNode<Integer>(9));
		
		GenTreeNode<Integer> root1 = new GenTreeNode<Integer>(10);
		root1.setLeft_child(new GenTreeNode<Integer>(7));
		root1.setRight_child(new GenTreeNode<Integer>(15));
		root1.getRight_child().setRight_child(new GenTreeNode<Integer>(11));
		root1.getLeft_child().setRight_child(new GenTreeNode<Integer>(9));
		
		
		System.out.println("Is tree1 foldable "+ isFoldable(root));
		System.out.println("Is tree1 foldable "+ isFoldable(root1));
	}
	
	public static boolean isFoldable(GenTreeNode<Integer> root){
		if(root == null)
			return true;
		
		// calculate the mirror image of the left subtree
		root.setLeft_child(createMirror(root.getLeft_child()));
		// check the both left and right subtree have same substructure
		return checkSameStructure(root.getLeft_child(), root.getRight_child()); 
	}
	
	public static boolean checkSameStructure(GenTreeNode<Integer> root1 , GenTreeNode<Integer> root2){
		if(root1 == null && root2 == null)
			return true;
		else if((root1 !=null && root2 == null) ||(root1 == null && root2 != null) )
			return false;
		
		boolean left = checkSameStructure(root1.getLeft_child(), root2.getLeft_child());
		boolean right = checkSameStructure(root1.getRight_child(), root2.getRight_child());
		
		return (left && right); 
		
	}
	
	public static GenTreeNode<Integer> createMirror(GenTreeNode<Integer> root){
		if(root == null)
			return null;
		
		root.setLeft_child(createMirror(root.getLeft_child()));
		root.setRight_child(createMirror(root.getRight_child()));
		
		GenTreeNode<Integer> temp = root.getLeft_child();
		root.setLeft_child(root.getRight_child());
		root.setRight_child(temp);
		
		return root;
		
	}
}
