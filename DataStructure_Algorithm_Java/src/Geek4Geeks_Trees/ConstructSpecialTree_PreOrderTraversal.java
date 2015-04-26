package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class ConstructSpecialTree_PreOrderTraversal {
	public static int index = 0;
	public static void main(String args[]){
		int pre[] = {10, 30, 20, 5, 15};
	    char preLN[] = {'N', 'N', 'L', 'L', 'L'};
	    GenTreeNode<Integer> root = null;
	    root = constructTree(pre,preLN,pre.length);
	    printTree(root);
    }
	
	public static void printTree(GenTreeNode<Integer> root){
		if(root == null)
			return;
		printTree(root.getLeft_child());
		System.out.print(root.getData()+" ,");
		printTree(root.getRight_child());
			
	}
	
	public static GenTreeNode<Integer> constructTree(int pre[] , char preLN[], int len){
		if(index == len){
			return null;
		}
		if(preLN[index] == 'L'){
			GenTreeNode<Integer> temp = new GenTreeNode<Integer>(pre[index++]);
			return temp;
		}
		
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(pre[index++]);
		
		root.setLeft_child(constructTree(pre,preLN,len));
		root.setRight_child(constructTree(pre,preLN,len));
		
		return root;
		
	}
	
}

