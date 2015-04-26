package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class PrintAllPaths_BinaryTree {
	public static void main(String args[]){
		GenTreeNode<Character> root = new GenTreeNode<Character>('a');
		root.setLeft_child(new GenTreeNode<Character>('b'));
		root.setRight_child(new GenTreeNode<Character>('c'));
		root.getLeft_child().setLeft_child(new GenTreeNode<Character>('d'));
		root.getLeft_child().setRight_child(new GenTreeNode<Character>('e'));
		root.getRight_child().setRight_child(new GenTreeNode<Character>('f'));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode<Character>('g'));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode<Character>('h'));
		printPaths(root);
	}
	
	public static void printPaths(GenTreeNode<Character> root){
		char path[] = new char[100];
		printAllPaths(root, path, 0);
		
	}
	
	public static void printAllPaths(GenTreeNode<Character> root, char path[], int pathlen){
		if(root == null)
			return;
		path[pathlen++] = root.getData();
		if(root.getLeft_child() == null && root.getRight_child() == null){
			printArr(path,pathlen);
			return;
		}
		else
			printAllPaths(root.getLeft_child(), path, pathlen);
			printAllPaths(root.getRight_child(), path, pathlen);
			return;
	}
	
	public static void printArr(char arr[], int pathlen){
		for(int i = 0 ; i< pathlen ;i++){
			System.out.print(arr[i] + " ,");
		}
		System.out.println();
		return;
	}
}
