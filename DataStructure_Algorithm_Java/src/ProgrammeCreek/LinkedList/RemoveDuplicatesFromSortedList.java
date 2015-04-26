package ProgrammeCreek.LinkedList;

public class RemoveDuplicatesFromSortedList {
	public static void main(String args[]){
		ListNode l1 = new ListNode(1);
		l1.next =new ListNode(1);
		//l1.next.next = new ListNode(3);
		//l1.next.next.next = new ListNode(4);
		printList(l1);
		l1 = deleteDuplicates(l1);
		printList(l1);
	}
	
	public static ListNode deleteDuplicates(ListNode head){
		if(head == null || head.next == null)
			return head;
		ListNode parent = head;
		ListNode child = head.next;
		
		while(child != null){
			if(parent.val == child.val){
				parent.next = child.next;
				child = child.next;
			}
			else{
				parent = parent.next;
				child = child.next;
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
