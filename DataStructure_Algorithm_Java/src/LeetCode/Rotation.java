package LeetCode;

public class Rotation {
	public static void main(String args[]){
		ListNode1 head = new ListNode1(1);
		head.next = new ListNode1(2);
		//head.next.next = new ListNode1(3);
		//head.next.next.next = new ListNode1(4);
		//head.next.next.next.next = new ListNode1(5);
		//head.next.next.next.next.next = new ListNode1(6);
		
		head = rotateRight(head, 2);
		printList(head);
	}
	
	public static void printList(ListNode1 head){
		ListNode1 temp = head;
		while(temp != null){
			System.out.print(temp.data+" ,");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static ListNode1 rotateRight(ListNode1 head, int k){
		if(k <=0){
			return head;
		}
		int listSize = 0;
		ListNode1 temp = head;
		while(temp != null){
			listSize++;
			temp = temp.next;
		}
		k = k%listSize;
		if(k == 0)
			return head;
		k = listSize -k;
		ListNode1 newHead = head;
		ListNode1 parent = null;
		int i =0;
		while(i<k){
			parent = newHead;
			newHead = newHead.next;
			i++;
		}
		parent.next = null;
		temp = newHead;
		while(temp.next != null)
			temp = temp.next;
		temp.next = head;
		head = newHead;
		return head;
	}
}

class ListNode1{
	int data;
	ListNode1 next;
	
	public ListNode1(int data){
		this.next = null;
		this.data = data;
	}
	
	public String toString(){
		return ""+this.data;
	}
}