package LeetCode;

public class ReverseNodes_KGroup {
	public static ListNode2 prevListLast = null, nextListHead = null;
	public static void main(String args[]){
		ListNode2 head = new ListNode2(1);
		head.next = new ListNode2(2);
		head.next.next = new ListNode2(3);
		head.next.next.next = new ListNode2(4);
		head.next.next.next.next = new ListNode2(5);
		
		ListNode2 revList = reverseKGroup(head, 3);
		printList(revList);
		
	}
	
	public static void printList(ListNode2 head){
		if(head == null)
			return;
		ListNode2 temp = head;
		while(temp != null){
			System.out.print(temp.val+"-> ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static ListNode2 reverseKGroup(ListNode2 head, int k){
		if(head == null || k <2)
			return head;
		int listLength = getListLength(head);
		if(listLength < k)
			return head;
		boolean firstSwap = false;
		int loopCount = listLength/k;
		ListNode2 newHead = head, child = head;
		for(int i = 0; i< loopCount ;i++){
			if(!firstSwap){
				newHead = reverseKList(child, k);
				firstSwap = true;
			}
			else{
				prevListLast.next = reverseKList(nextListHead,k);
			}
		}
		prevListLast.next = nextListHead;
		
		return newHead;
		
	}
	
	
	public static ListNode2 reverseKList(ListNode2 head, int k){
		if(head == null || head.next == null){
			nextListHead = null;
			prevListLast = head;
			return head;
		}
		ListNode2 parent = head;
		ListNode2 child = head.next;
		
		return inverseList(parent, child , k);
		
	}
	
	public static ListNode2 inverseList(ListNode2 parent , ListNode2 child , int k){
		if( k == 2){
			nextListHead = child.next;
			child.next = parent;
			parent.next = null;
			prevListLast = parent;
			return child;
		}
		ListNode2 newHead = inverseList(parent.next,child.next,--k);
		child.next = parent;
		parent.next = null;
		prevListLast = parent;
		
		return newHead;
	}
	
	public static int getListLength(ListNode2 head){
		if(head == null)
			return 0;
		ListNode2 temp =head;
		int count =0;
		while(temp != null){
			temp = temp.next;
			count++;
		}
		return count;
	}
}



class ListNode2 {
	int val;
	ListNode2 next;
	ListNode2 (int val){
		this.val = val;
		this.next = null;
	}
	
	public String toString(){
		return this.val +"";
	}
}
