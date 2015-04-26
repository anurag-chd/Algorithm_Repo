package Geek4Geeks_Trees;

import java.util.LinkedList;
import java.util.Queue;

import Basics.GenTreeNode;

public class BinaryTree_CompleteBinaryTree {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getRight_child().setLeft_child(new GenTreeNode(11));
		root.getLeft_child().getLeft_child().setLeft_child(new GenTreeNode(7));
		root.getLeft_child().getLeft_child().setRight_child(new GenTreeNode(9));
		
		System.out.println("Is the tree complete binary tree "+ checkCompleteBinaryTree(root));
	}
	
	public static boolean checkCompleteBinaryTree(GenTreeNode<Integer> root){
		if(root == null)
			return true;
		
		Queue<GenTreeNode<Integer>> nodeList = new LinkedList<>();
		boolean lastFlag = false;
		nodeList.add(root);
		while(!nodeList.isEmpty()){
			GenTreeNode<Integer> temp = nodeList.poll();
			if(temp.getLeft_child() == null && temp.getRight_child() != null){
				return false;
			}
			if(temp.getLeft_child() != null && temp.getRight_child() == null){
				nodeList.add(temp.getLeft_child());
				lastFlag = true;
			}
			else if(temp.getLeft_child() != null && temp.getRight_child() != null){
				if(lastFlag == true)
					return false;
				else{
					nodeList.add(temp.getLeft_child());
					nodeList.add(temp.getRight_child());
				}
			}
		}
		return true;
	}
}
