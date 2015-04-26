package ProgrammeCreek_Sorting;

public class MergeSortLinkedList {
	public static void main(String args[]){
		ListNode head = new ListNode(10);
		head.next = new ListNode(4);
		head.next.next = new ListNode(18);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(21);
		head.next.next.next.next.next = new ListNode(3);
		
		printList(head);
		int len = getListLength(head);
		head = sortList(head,len);
		
		printList(head);
	}
	
	public static ListNode sortList(ListNode head,int len){
		if(len<2 || head.next == null){
			return head;
		}
		ListNode temp1 = head;
		for(int i =0; i< len/2-1 ;i++)
			temp1 = temp1.next;
		ListNode temp2 = temp1.next;
		temp1.next = null;
		
		ListNode leftList = sortList(head,len/2);
		ListNode rightList = sortList(temp2,(len-len/2));
		
		return sortParts(leftList,rightList);
	}
	
	public static ListNode sortParts(ListNode list1, ListNode list2){
		if(list1 == null)
			return list2;
		else if(list2 == null)
			return list1;
		else{
			ListNode mergeHead = null;
			ListNode temp = null;
			while(list1 != null && list2 != null){
				if(mergeHead == null){
					if(list1.val < list2.val){
						mergeHead = list1;
						temp = list1;
						list1 = list1.next;
					}
					else{
						mergeHead = list2;
						temp = list2;
						list2 = list2.next;
					}
				}
				else{
					if(list1.val < list2.val){
						temp.next = list1;
						temp = temp.next;
						list1 = list1.next;
					}
					else{
						temp.next = list2;
						temp = temp.next;
						list2 = list2.next;
					}
				}
			}
			temp.next = (list1 ==null)?list2:list1;
			return mergeHead;
		}
	}
	
	public static int getListLength(ListNode head){
		int len = 0;
		ListNode temp = head;
		while(temp != null){
			len++;
			temp = temp.next;
		}
		return len;
	}
	
	public static void printList(ListNode head){
		ListNode temp = head;
		while(temp != null){
			System.out.print(temp.val+"-> ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	
}

class ListNode{
	int val;
	ListNode next;
	
	public ListNode(int val){
		this.val = val;
		this.next = null;
	}
	
	public String toString(){
		return String.valueOf(this.val);
	}
}
