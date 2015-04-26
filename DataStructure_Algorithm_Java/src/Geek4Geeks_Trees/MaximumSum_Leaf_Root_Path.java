package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class MaximumSum_Leaf_Root_Path {
	static int max= 0;
	static int max_leaf = 0;
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(7));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		
		findMaxPath(root, null, 0);
		int height  = getTreeHeight(root);
		int arr[] = new int[height];
		
		printPath(root, arr,0);
		
	}
	
	public static void printPath(GenTreeNode<Integer> root, int arr[], int index){
		if(root == null)
			return;
		arr[index++] = root.getData();
		if(root.getData() == max_leaf){
			printArr(arr);
		}
		printPath(root.getLeft_child(),arr,index);
		
		printPath(root.getRight_child(),arr,index);
		arr[--index] =-1;
		
		
	}
	
	public static void printArr(int arr[]){
		for(int i =0; i< arr.length;i++){
			if(arr[i] ==-1)
				return;
			System.out.print(arr[i]+" ,");
		}
	}
	
	public static int getTreeHeight(GenTreeNode<Integer> root){
		if(root == null)
			return 0;
		return 1 + Math.max(getTreeHeight(root.getLeft_child()), getTreeHeight(root.getRight_child()));
	}
	
	public static void findMaxPath(GenTreeNode<Integer> root,GenTreeNode<Integer> parent, int sum){
		if(root == null){
			if(sum > max){
				max = sum;
				if(parent != null)
					max_leaf = parent.getData();
			}
			return;
		}
		parent = root;
		sum = sum + root.getData();
		findMaxPath(root.getLeft_child(), parent,sum);
		findMaxPath(root.getRight_child(), parent,sum);
		
	}
}
