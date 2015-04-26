package Geek4Geeks_Trees;

import java.util.Stack;

import Basics.GenTreeNode;

public class BinaryTree_isBST {
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
		GenTreeNode<Integer> root2 = new GenTreeNode<Integer>(10);
		root2.setLeft_child(new GenTreeNode(6));
		root2.setRight_child(new GenTreeNode(12));
		root2.getLeft_child().setLeft_child(new GenTreeNode(4));
		root2.getLeft_child().setRight_child(new GenTreeNode(8));
		root2.getRight_child().setRight_child(new GenTreeNode(14));
		root2.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(15));
		root2.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		
		// check first tree
		
		if(isBST(root)){
			System.out.println("Tree 1 is BST");
		}
		else{
			System.out.println("Tree 1 is notBST");
		}
		
		// check second tree
		
		if(isBST(root2)){
			System.out.println("Tree 2 is BST");
		}
		else{
			System.out.println("Tree 2 is notBST");
		}
					
				
		
	}
	
	
	public static boolean isBST(GenTreeNode<Integer> root){
		if(root == null){
			return true;
		}
		
		Stack<GenTreeNode<Integer>> stack = new Stack<GenTreeNode<Integer>>();
		stack.push(root);
		while(!stack.isEmpty()){
			GenTreeNode<Integer> temp = stack.pop();
			if(temp.getLeft_child()!=null){
				if(temp.getData() < temp.getLeft_child().getData())
					return false;
				else{
					stack.push(temp.getLeft_child());
				}
			}
			if(temp.getRight_child()!=null){
				if(temp.getData() > temp.getRight_child().getData())
					return false;
				else{
					stack.push(temp.getRight_child());
				}
			}
		}
		
		return true;
		
	}

}
