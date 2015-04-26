package ProgrammeCreek.LinkedList;

public class AddTwoNumbers {
	public static void main(String args[]){
		ListNode l1 = new ListNode(2);
		l1.next =new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next =new ListNode(6);
		l2.next.next = new ListNode(4);
		
		printList(l1);
		printList(l2);
		ListNode head = addTwoNumbers(l1,l2);
		printList(head);
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
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
		if(l1 == null && l2 == null)
			return null;
		else if(l1 == null)
			return l2;
		else if(l2 == null)
			return l1;
		
		ListNode head = null;
		boolean carry = false;
		head = addNum(l1,l2,head,carry);
		return head;
	}
	
	public static ListNode addNum(ListNode l1, ListNode l2, ListNode head, boolean carry){
		if(l1 == null && l2 == null && !carry)
			return head ;
		else if(l1 == null && l2 == null){
			head = new ListNode(1);
			return head;
		}
			
			
		else if(l1 != null && l2 != null){
			if(carry){
				int sum = l1.val + l2.val + 1;
				if(sum > 9){
					head = new ListNode(sum%10);
					carry = true;
				}
				else{
					head = new ListNode(sum);
					carry = false;
				}
			}
			else{
				int sum = l1.val + l2.val;
				if(sum > 9){
					head = new ListNode(sum%10);
					carry = true;
				}
				else{
					head = new ListNode(sum);
					carry = false;
				}
			}
			head.next = addNum(l1.next,l2.next,head.next,carry);
		}
		else if(l1 == null){
			if(carry){
				int sum = l2.val + 1;
				if(sum > 9){
					head = new ListNode(sum%10);
					carry = true;
				}
				else{
					head = new ListNode(sum);
					carry = false;
				}
			}
			else{
				int sum = l2.val;
				if(sum > 9){
					head = new ListNode(sum%10);
					carry = true;
				}
				else{
					head = new ListNode(sum);
					carry = false;
				}
			}
			head.next =	addNum(null,l2.next,head.next,carry);
			
		}
		else if(l2 == null){
			if(carry){
				int sum = l1.val + 1;
				if(sum > 9){
					head = new ListNode(sum%10);
					carry = true;
				}
				else{
					head = new ListNode(sum);
					carry = false;
				}
			}
			else{
				int sum = l1.val;
				if(sum > 9){
					head = new ListNode(sum%10);
					carry = true;
				}
				else{
					head = new ListNode(sum);
					carry = false;
				}
			}
			 head.next = addNum(l1.next,null,head.next,carry);
		}
		return head;
	}
}

class ListNode{
	int val;
	ListNode next;
	public ListNode(int value){
		this.val = value;
		this.next = null;
	}
	
	public String toString(){
		return Integer.toString(this.val);
	}
}
