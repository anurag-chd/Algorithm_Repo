package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class TreeTraversalLevelOrder {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(7));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		
		levelOrderPrint(root);
		
	}
	
	public static void levelOrderPrint(GenTreeNode<Integer> root){
		if(root == null){
			return;
		}
		
		int height = calTreeHeight(root);
		boolean LeftToRight = true;
		for(int i =1 ;i<= height ;i++){
			
			
			printLevelNodes(root,i,LeftToRight);
			System.out.println();
			LeftToRight = !LeftToRight;
		}
	}
	
	
	public static void printLevelNodes(GenTreeNode<Integer> root , int level, boolean flag){
		if(root == null){
			return;
		}
		if(level == 1){
			System.out.print(root.getData()+ "  ");
			return;
		}
		if(flag == true){
			printLevelNodes(root.getLeft_child(),level-1,flag);
			printLevelNodes(root.getRight_child(),level-1,flag);
		}
		else{
			
			printLevelNodes(root.getRight_child(),level-1,flag);
			printLevelNodes(root.getLeft_child(),level-1,flag);
		}
		
			
		return;
	}
	
	
	public static int calTreeHeight(GenTreeNode<Integer> root){
		if (root == null){
			return 0;
		}
		return (1 + Math.max(calTreeHeight(root.getLeft_child()),calTreeHeight(root.getRight_child())));
	}

}
