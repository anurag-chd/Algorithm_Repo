package ProgrammeCreek.LinkedList;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {
	public static void main(String args[]){
		ListNode l1 = new ListNode(-2);
		l1.next = new ListNode(-1);
		l1.next.next = new ListNode(-1);
		l1.next.next.next = new ListNode(-1);
		
		ListNode l2 = null;
		/*ListNode l2 = new ListNode(2);
		l2.next = new ListNode(13);
		l2.next.next = new ListNode(14);
		l2.next.next.next = new ListNode(16);
		*/
		/*ListNode l3 = new ListNode(30);
		l3.next = new ListNode(40);
		l3.next.next = new ListNode(50);
		l3.next.next.next = new ListNode(60);
		
		ListNode l4 = new ListNode(3);
		l4.next = new ListNode(15);
		l4.next.next = new ListNode(25);
		l4.next.next.next = new ListNode(65);
		
		*/
		List<ListNode> list = new LinkedList<>();
		list.add(l1);list.add(l2);//list.add(l3);list.add(l4);
		
		ListNode head = mergeKLists(list);
		
		printList(head);
	}
	
	public static ListNode mergeKLists(List<ListNode> lists){
		if(lists == null)
			return null;
		
		PriorityQueue<ListNode> queue = new PriorityQueue<>(new ListComarator());
		// populate the priority queue
		for(ListNode l : lists){
			ListNode temp = l;
			while(temp != null){
				queue.add(temp);
				temp = temp.next;
			}
		}
		
		ListNode head = null, temp = null;
		
		
		while(!queue.isEmpty()){
			System.out.println(queue);
			if(head == null){
				head = queue.poll();
				temp = head;
				temp.next = null;
			}
			else{
				temp.next = queue.poll();
				temp = temp.next;
				temp.next = null;
			}
			
		}
		return head;
	}
	public static void printList(ListNode node){
		if(node == null){
			return;
		}
		ListNode temp = node;
		while(temp != null){
			System.out.print(temp.val +"->");
			temp = temp.next;
		}
		System.out.println();
	}
}

class ListComarator implements Comparator<ListNode>{

	@Override
	public int compare(ListNode l1, ListNode l2) {
		
		return l1.val - l2.val;
	}
	
}
