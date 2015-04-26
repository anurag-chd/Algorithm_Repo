package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class PrintAncestor_BTree {
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
		
		GenTreeNode<Integer> node = new GenTreeNode<Integer>(9);
		printParents(root,node);
		
	}
	
	public static void printParents(GenTreeNode<Integer> root,GenTreeNode<Integer> node){
		if(root.getData() == node.getData())
			return;
		int height = getMaxHeight(root);
		System.out.println(height);
		int par[] = new int[height];
		printP(root,node,par,0);
	}
	
	public static void printP(GenTreeNode<Integer> root, GenTreeNode<Integer> node, int par[],int level){
		if(root == null || flag == true)
			return;
		if(root.getData() == node.getData()){
			printArr(par,level);
			flag = true;
		}
		par[level++] = root.getData();
		
		
		printP(root.getLeft_child(),node,par,level);
		printP(root.getRight_child(),node,par,level);
		
	}
	
	public static void printArr(int arr[],int level){
		for(int i =0; i <= level-1 ; i++){
			System.out.print(arr[i] + ", ");
		}
		
	}
	
	public static int getMaxHeight(GenTreeNode<Integer> root){
		if(root == null)
			return 0;
		return (1 + Math.max(getMaxHeight(root.getLeft_child()),getMaxHeight(root.getRight_child())));
	}
}
