package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class PeripheralTraversal {
	public static void main(String args[]){
		GenTreeNode<Character> root = new GenTreeNode<Character>('a');
		root.setLeft_child(new GenTreeNode('b'));
		root.setRight_child(new GenTreeNode('c'));
		root.getLeft_child().setLeft_child(new GenTreeNode('d'));
		root.getLeft_child().setRight_child(new GenTreeNode('e'));
		root.getRight_child().setRight_child(new GenTreeNode('f'));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode('g'));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode('h'));
		
		printPeripherals(root);
	}
	
	public static void printPeripherals(GenTreeNode root){
		if(root == null){
			System.out.println("Empty Tree");
			return;
		}
		System.out.println(root.getData());
		printLeftBoundary(root.getLeft_child());
		printLeaves(root.getLeft_child());
		printLeaves(root.getRight_child());
		printRightBoundary(root.getRight_child());
	}
	
	public static void printLeftBoundary(GenTreeNode root){
		if(root == null){
			return;
		}
		if(root.getLeft_child() != null){
			System.out.println(root.getData());
			printLeftBoundary(root.getLeft_child());
		}
		else if(root.getRight_child() != null){
			System.out.println(root.getData());
			printLeftBoundary(root.getRight_child());
		}
	}
	
	public static void printLeaves(GenTreeNode root){
		if(root != null){
			printLeaves(root.getLeft_child());
			if(root.getLeft_child() == null && root.getRight_child() == null){
				System.out.println(root.getData());
			}
			printLeaves(root.getRight_child());
		}
	}
	
	public static void printRightBoundary(GenTreeNode root){
		if(root !=null){
			if(root.getLeft_child() != null){
				printRightBoundary(root.getLeft_child());
				System.out.println(root.getData());
			}
			else if(root.getRight_child() != null){
				printRightBoundary(root.getRight_child());
				System.out.println(root.getData());
			}
		}
	}
}
