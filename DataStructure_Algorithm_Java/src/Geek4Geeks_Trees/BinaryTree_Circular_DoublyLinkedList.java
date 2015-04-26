package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class BinaryTree_Circular_DoublyLinkedList {
	static GenTreeNode<Integer> prev = null; 
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(7));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		GenTreeNode<Integer> head = null;
		head = convertTree(root,head);
		
		printList(head);
		
	}
	
	public static void printList(GenTreeNode head){
		GenTreeNode<Integer> temp = head;
		System.out.print(temp.getData());
		temp = temp.getRight_child();
		while(temp != head){
			System.out.print(", "+temp.getData());
			temp = temp.getRight_child();
		}
	}
	public static GenTreeNode<Integer> convertTree(GenTreeNode<Integer> root,GenTreeNode<Integer> head){
		if(root == null){
			return head;
		}
		head = convertTree(root.getLeft_child(),head);
		if(head == null){
			head = root;
		}
		root.setLeft_child(prev);
		if(prev!=null){
			prev.setRight_child(root);
		}
		
		GenTreeNode right = root.getRight_child() ; // so that it does not traverse in loop
		prev = root;
		head.setLeft_child(root);
		root.setRight_child(head);
		head = convertTree(right,head);
		
		return head;
	}
}
