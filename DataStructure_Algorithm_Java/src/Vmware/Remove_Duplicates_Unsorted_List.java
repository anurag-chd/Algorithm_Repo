package Vmware;

import java.util.HashSet;

import Basics.LinkedList;

public class Remove_Duplicates_Unsorted_List {
	public static void main(String args[]){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(5);
		list.insert(1);
		list.insert(3);
		list.insert(10);
		list.insert(2);
		list.insert(5);
		list.insert(3);
		list.insert(1);
		
		printList(list);
		
		// remove duplicates
		rmDup(list);
		
		printList(list);
		
	}
	
	public static void printList(LinkedList list){
		Basics.Node temp = list.getHead();
		while(temp!=null){
			System.out.print(temp.getvalue() + " ," );
			temp = temp.getNext();
		}
		System.out.println();
		
	}
	
	public static void rmDup(LinkedList list){
		HashSet<Integer> set = new HashSet<Integer>();
		
		Basics.Node parent = list.getHead();
		Basics.Node child = parent.getNext();
		set.add((Integer)parent.getvalue());
		
		while(child!=null){
			if(!set.contains(child.getvalue())){
				set.add((Integer)child.getvalue());
				parent = parent.getNext();
				child = parent.getNext();
			}
			else{
				parent.setNext(child.getNext());
				child = parent.getNext();
			}
		}
	}
}
