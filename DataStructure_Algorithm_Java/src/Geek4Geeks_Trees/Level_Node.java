package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class Level_Node {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(7));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		
		
		GenTreeNode<Integer> node = new GenTreeNode<Integer>(8);
		getLevel(root, node, 1);
	}
	
	public static void getLevel(GenTreeNode<Integer> root,GenTreeNode<Integer> node, int level){
		if(root == null || node == null){
			return;
		}
		if(root.getData() == node.getData()){
			System.out.println(level);
		}
		level++;
		getLevel(root.getLeft_child(),node,level);
		getLevel(root.getRight_child(),node,level);
		
	}
}
