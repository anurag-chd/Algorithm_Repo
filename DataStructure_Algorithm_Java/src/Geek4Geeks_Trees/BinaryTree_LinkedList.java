package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class BinaryTree_LinkedList {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(7));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		
		DoublyLinkedList list = new DoublyLinkedList();
		list = createList(root,list);
		DNode temp = list.head;
		while(temp.prev!=null){
			temp = temp.prev;
		}
		while(temp!=null){
			System.out.print(temp.data + " ,");
			temp = temp.next;
		}
	}
	
	public static DoublyLinkedList createList(GenTreeNode<Integer> root, DoublyLinkedList list){
		if(root == null){
			return list;
		}
		list = createList(root.getLeft_child(),list);
		list.insert(root.getData());
		list = createList(root.getRight_child(),list);
		
		return list;
	}
}

class DoublyLinkedList{
	DNode head;
	
	public DoublyLinkedList(){
		head = null;
	}
	
	public void insert(int data){
		DNode temp = new DNode(data);
		if(head == null){
			head = temp;
		}
		else{
			head.next = temp;
			temp.prev = head;
			head = temp;
		}
	}
}

class DNode{
	int data;
	DNode prev;
	DNode next;
	
	public DNode(int data){
		this.data = data;
		this.prev = null;
		this.next = null;
	}
	
	public DNode(){
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public DNode getPrev() {
		return prev;
	}
	public void setPrev(DNode prev) {
		this.prev = prev;
	}
	public DNode getNext() {
		return next;
	}
	public void setNext(DNode next) {
		this.next = next;
	}
}
