package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class LargestBST_Subtree {
	static GenTreeNode<Integer> parent = null;
	static int max_size = 1;
	static int sum =1;
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<>(50);
		root.setLeft_child(new GenTreeNode<>(30));
		root.setRight_child(new GenTreeNode<>(60));
		root.getLeft_child().setLeft_child(new GenTreeNode<>(5));
		root.getLeft_child().setRight_child(new GenTreeNode<>(20));
		
		root.getRight_child().setLeft_child(new GenTreeNode<>(45));
		root.getRight_child().setRight_child(new GenTreeNode<>(70));
		
		root.getRight_child().getRight_child().setLeft_child(new GenTreeNode<>(65));
		root.getRight_child().getRight_child().setRight_child(new GenTreeNode<>(80));
		
		getBSTSize(root);
		
		System.out.println("The largest BST size is "+ sum + " max size "+ max_size);
	}
	
	
	public static void getBSTSize(GenTreeNode<Integer> root){
		if(root == null)
			return ;
		
		getBSTSize(root.getLeft_child());
		getBSTSize(root.getRight_child());
		if(root.getLeft_child()!= null && root.getRight_child() != null){
			if(root.getData() > root.getLeft_child().getData() && root.getData() < root.getRight_child().getData()){
				sum = sum +2;
			}
			else{
				sum = 1;
			}
		}
		
		if(root.getLeft_child()!= null && root.getRight_child() == null){
			if(root.getData() > root.getLeft_child().getData()){
				sum = sum +1;
			}
			else{
				sum = 1;
			}
		}
		
		if(root.getLeft_child()== null && root.getRight_child() != null){
			if(root.getData() < root.getRight_child().getData()){
				sum = sum +1;
			}
			else{
				sum = 1;
			}
		}
		
		if(sum > max_size)
			max_size = sum;
		/*if(parent != null){
			if(parent.getData() < root.getData()){
				
				sum++;
				System.out.println(sum);
			}
			else{
				sum = 1;
			}
		}
		
		parent = root;
		System.out.println(parent.getData());
		
		if(sum > max_size)
			max_size = sum;
		
		getBSTSize(root.getRight_child());
		
*/		
		
	}
}
