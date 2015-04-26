
public class ReverseLinkedList {
	public static void main(String args[]){
		ListNode l1 = new ListNode(2);
		l1.next =new ListNode(4);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(6);
		printList(l1);
		l1 = reverseList(l1);
		
		printList(l1);
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
			System.out.print(temp.data +"->");
			temp = temp.next;
		}
		System.out.println();
	}
	
}

class ListNode{
	int data;
	ListNode next;
	
	public ListNode(int data){
		this.data = data;
		this.next = null;
	}
}
