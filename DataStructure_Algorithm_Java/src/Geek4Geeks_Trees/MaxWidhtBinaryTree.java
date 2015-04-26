package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class MaxWidhtBinaryTree {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(7));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		
		maxWidth(root);
	}
	
	public static void maxWidth(GenTreeNode<Integer> root){
		int height = getMaxHeight(root);
		
		int count [] = new int [height];
		for(int i = 0; i< count.length;i++){
			count[0] = 0;
		}
		count = getCountArr(root,count,0);
		
		int max = 0;
		
		for(int num : count){
			System.out.print(num + " ,");
			if(max<num)
				max = num;
		}
		System.out.println();
		System.out.println(max);
		return;
		
	}
	
	public static int [] getCountArr(GenTreeNode<Integer> root , int count[], int index){
		if(root == null)
			return count;
		
		count[index]++;
		index++;
		
		 getCountArr(root.getLeft_child(),count,index);
		 getCountArr(root.getRight_child(),count,index);
		return count;
		
	}
	
	public static int getMaxHeight(GenTreeNode<Integer> root){
		if(root == null)
			return 0;
		return 1+ Math.max(getMaxHeight(root.getLeft_child()),getMaxHeight(root.getRight_child()));
	}
}
