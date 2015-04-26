package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class ConvertBtree_ChildSumTree {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(7));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		
		printTree(root);
		System.out.println();
		GenTreeNode<Integer> temp;
		temp = convertSumChildTree(root);
		System.out.println();
		System.out.println("New tree");
		
		
		printTree(temp);
		System.out.println(root.getLeft_child());
	}
	
	public static GenTreeNode<Integer> convertSumChildTree(GenTreeNode<Integer> root){
		if(root == null)
			return root;
		
		root.setLeft_child(convertSumChildTree(root.getLeft_child()));
		root.setRight_child(convertSumChildTree(root.getRight_child()));
		
		System.out.print(root.getData() +" ");
		
		if(root.getLeft_child() != null && root.getRight_child() != null){
			System.out.println( root.getLeft_child().getData()+ " "+root.getRight_child().getData() );
			int dif = root.getData() - (root.getLeft_child().getData() + root.getRight_child().getData());
			if(dif>0){
				root.setData((root.getData() - dif));
			}
			else{
				dif = -1 * dif;
				root.setData((root.getData() + dif));
			}
		}
		
		else if(root.getLeft_child() != null && root.getRight_child() == null ){
			System.out.println(root.getLeft_child().getData()+" " );
			int dif = root.getData() - root.getLeft_child().getData();
			if(dif>0){
				root.setData((root.getData() - dif));
			}
			else{
				dif = -1 * dif;
				root.setData((root.getData() + dif));
			}
		}
		
		else if(root.getLeft_child() == null && root.getRight_child() != null ){
			System.out.println(root.getRight_child().getData()+" " );
			int dif = root.getData() - root.getRight_child().getData();
			if(dif>0){
				root.setData((root.getData() - dif));
			}
			else{
				dif = -1 * dif;
				root.setData((root.getData() + dif));
			}
		}
		return root;
		
	}
	
	public static void printTree(GenTreeNode<Integer> root){
		if(root == null)
			return;
		printTree(root.getLeft_child());
		System.out.println(root.getData());
		printTree(root.getRight_child());
	}

}
