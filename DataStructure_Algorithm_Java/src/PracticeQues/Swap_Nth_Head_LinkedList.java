package PracticeQues;

import Basics.LinkedList;
import Basics.Node;

public class Swap_Nth_Head_LinkedList {
	public static void main(String args[]){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		printList(list);
		list= swap(list,3);
		printList(list);
	}
	
	public static void printList(LinkedList<Integer> list){
		Node<Integer> temp = list.getHead();
		while(temp != null){
			System.out.print(temp.getvalue()+ " " );
			temp = temp.getNext();
		}
		System.out.println();
	}
	
	public static LinkedList<Integer> swap(LinkedList<Integer> list ,int n){
		Node head = list.getHead();
		Node temp = head;
		int count =1;
		while(count<n-1){
			if(temp == null){
				System.out.println("length of list less then n");
				return null;
			}
			
			temp = temp.getNext();
			count++;
		}
		Node n_node = temp.getNext();
		
		Node n_next = n_node.getNext();
		temp.setNext(head);
		n_node.setNext(head.getNext());
		head.setNext(n_next);
		
		list.setHead(n_node);
		
		return list;
		
	}
}
