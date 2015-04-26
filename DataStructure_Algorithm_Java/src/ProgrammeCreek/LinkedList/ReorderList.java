package ProgrammeCreek.LinkedList;

public class ReorderList {
	public static void main(String args[]){
		ListNode l1 = new ListNode(1);
		l1.next =new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		l1.next.next.next.next = new ListNode(5);
		
		ListNode head = l1;
		printList(head);
		reorderList(head);
		printList(head);
	}
	public static void reorderList(ListNode head){
		if(head == null || head.next ==null)
			return ;
		ListNode parentList = head;
		ListNode childList = head.next;
		while(childList.next != null){
			childList = childList.next;
			if(childList.next == null)
				break;
			childList = childList.next;
			parentList = parentList.next;
		}
		childList = parentList.next;
		parentList.next = null;
		childList = reverseList(childList);
		ListNode parent = head;
		while(parent.next != null && childList.next != null){
			ListNode temp1 = parent.next;
			ListNode temp2 = childList.next;
			parent.next = childList;
			childList.next = temp1;
			parent = temp1;
			childList = temp2;
		}
		if(childList != null)
			parent.next = childList;
		
		
		
	}
	public static ListNode reverseList(ListNode l1){
		if(l1 == null || l1.next == null)
			return l1;
		ListNode parent = l1;
		ListNode child = parent.next;
		ListNode head = null;
		l1 = revList(parent,child,head);
		
		return l1;
		
	}
	
	public static ListNode revList(ListNode parent,ListNode child,ListNode head){
		if(child.next == null){
			child.next = parent;
			parent.next = null;
			head = child;
			return head;
		}
		head = revList(parent.next,child.next,head);
		child.next = parent;
		parent.next = null;
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

