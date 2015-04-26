package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class SpecialBinaryTree_Inorder {
	public static void main(String args[]){
		int inorder[] = {5, 10, 40, 30, 28};
		GenTreeNode<Integer> root = null;
		root = createSpecialBinaryTree(inorder,0,inorder.length-1);
		printTree(root);
	}
	
	public static void printTree(GenTreeNode<Integer> root){
		if(root == null)
			return;
		printTree(root.getLeft_child());
		System.out.print(root.getData()+" ,");
		printTree(root.getRight_child());
			
	}
	
	public static GenTreeNode createSpecialBinaryTree(int inorder[], int start, int end){
		if(start > end){
			return null; 
		}
		int index = findMax(inorder, start, end);
		GenTreeNode<Integer> root = new GenTreeNode(inorder[index]);
		root.setLeft_child(createSpecialBinaryTree(inorder,start,index-1));
		root.setRight_child(createSpecialBinaryTree(inorder,index+1,end));
		
		return root;
	}
	
	public static int findMax(int inorder[], int start , int end){
		int max = 0;
		int index = -1;
		for(int i = start ; i<= end ;i++){
			if(max < inorder[i]){
				max = inorder[i];
				index = i;
			}
				
		}
		return index;
	}

}
