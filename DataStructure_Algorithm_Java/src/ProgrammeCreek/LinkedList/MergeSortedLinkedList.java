package ProgrammeCreek.LinkedList;

public class MergeSortedLinkedList {
	public static void main(String args[]){
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(10);
		l1.next.next = new ListNode(12);
		l1.next.next.next = new ListNode(20);
		
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(13);
		l2.next.next = new ListNode(14);
		l2.next.next.next = new ListNode(16);
		printList(l1);
		printList(l2);
		ListNode head = mergeList(l1,l2);
		printList(head);
		
		
	}
	
	public static ListNode mergeList(ListNode l1, ListNode l2){
		if(l1 == null && l2 == null)
			return l1;
		else if(l1 == null)
			return l2;
		else if(l2 == null)
			return l1;
		ListNode head = null, mainHead = null;
		
		while(l1 != null && l2 != null){
			if(l1.val > l2.val){
				if(head == null){
					head = l2;
					mainHead = head;
				}
					
				else{
					head.next = l2;
					head = head.next;
				}
				l2 = l2.next;
				
				if(l2 == null){
					head.next = l1;
					break;
				}
				if(l2.val == 13){
					System.out.println();
				}
			}
			else{
				if(head == null){
					head = l1;
					mainHead = head;
				}
				else{
					head.next = l1;
					head = head.next;
				}
				l1 = l1.next;
				if(l1 == null){
					head.next = l2;
					break;
				}
			}
			
			
			
		}
		return mainHead;
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


