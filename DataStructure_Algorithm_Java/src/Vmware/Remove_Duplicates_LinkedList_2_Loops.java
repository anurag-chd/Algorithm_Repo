package Vmware;

import Basics.LinkedList;

public class Remove_Duplicates_LinkedList_2_Loops {
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
	
	public static void rmDup(LinkedList list){
		Basics.Node ptr1 = list.getHead();
		while(ptr1.getNext() != null){
			Basics.Node ptr2_parent = ptr1;
			Basics.Node ptr2 = ptr2_parent.getNext() ;
			
			while(ptr2 != null){
				if(ptr2.getvalue() == ptr1.getvalue()){
					ptr2_parent.setNext(ptr2.getNext());
					ptr2 = ptr2_parent.getNext();
				}
				else{
					ptr2 = ptr2.getNext();
					ptr2_parent = ptr2_parent.getNext();
				}
			}
			ptr1 = ptr1.getNext();
		}
	}
	
	public static void printList(LinkedList list){
		Basics.Node temp = list.getHead();
		while(temp!=null){
			System.out.print(temp.getvalue() + " ," );
			temp = temp.getNext();
		}
		System.out.println();
		
	}

}
