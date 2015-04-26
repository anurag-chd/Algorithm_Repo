package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class SumTree {
	static int sum =0;
	public static void main(String args[]){
		
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(27);
		root.setLeft_child(new GenTreeNode<Integer>(10));
		root.setRight_child(new GenTreeNode<Integer>(3));
		root.getLeft_child().setLeft_child(new GenTreeNode<Integer>(4));
		root.getLeft_child().setRight_child(new GenTreeNode<Integer>(6));
		root.getRight_child().setRight_child(new GenTreeNode<Integer>(3));
		
		System.out.println("Is the give tree sum tree" + isSumTree(root));
		System.out.println("Tree sum is "+ calsum(root));
	}
	
	public static boolean isSumTree(GenTreeNode<Integer> root){
		if(root == null)
			return true;
		/*if(root.getLeft_child() == null && root.getRight_child() == null){
			
			sum = sum + root.getData();
			System.out.println(sum);
			return true;
		}
		boolean left  = isSumTree(root.getLeft_child(), sum);
		boolean right  = isSumTree(root.getRight_child(), sum);
		if(left == false || right == false)
			return false;
		if(root.getData() == sum){
			sum = sum + root.getData();
			return true;
		}
		else{
			System.out.println("Sum "+sum+" root data "+ root.getData());
			return false;
		}
		*/
		if(root.getLeft_child() == null && root.getRight_child() == null)
			return true;
		boolean left  = isSumTree(root.getLeft_child());
		boolean right  = isSumTree(root.getRight_child());
		if(left == false || right == false)
			return false;
		sum =0;
		sum = calsum(root);
		System.out.println(sum);
		if(sum == 2 * root.getData())
			return true;
		else
			return false;
	}
	
	
	public static int calsum(GenTreeNode<Integer> root){
		if(root == null)
			return 0;
		
		 
		return root.getData() + calsum(root.getLeft_child()) + calsum(root.getRight_child());
		 
	
		
		
		//
		
	}
}
