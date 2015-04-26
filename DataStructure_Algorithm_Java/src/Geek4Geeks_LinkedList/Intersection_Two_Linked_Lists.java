package Geek4Geeks_LinkedList;

public class Intersection_Two_Linked_Lists {
	public static void main(String args[]){
		ListNode list1_head = new ListNode(1);
		ListNode list2_head = new ListNode(6);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		ListNode seven = new ListNode(7);
		ListNode eight = new ListNode(8);
		
		list1_head.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		list2_head.next = seven;
		seven.next = eight;
		eight.next = three;
		
		if(listMerge(list1_head,list2_head)){
			System.out.println("list is metged");
			ListNode result = getMergeNode(list1_head,list2_head);
			System.out.println("the lists are meged at node " + result.data);
			
		}
		else{
			System.out.println("lists are not merged");
		}
		
	}
	
	public static boolean listMerge(ListNode head1, ListNode head2){
		ListNode iterator1 = head1;
		ListNode iterator2 = head2;
		
		while(iterator1.next != null)
			iterator1 = iterator1.next;
		
		while(iterator2.next != null)
			iterator2 = iterator2.next;
		
		if(iterator1 == iterator2)
			return true;
		else{
			return false;
		}
	}
	
	
	public static ListNode getMergeNode(ListNode head1 , ListNode head2){
		int len1 = 0; // length of list 1
		int len2 = 0; // length of list 2
		
		ListNode iterator1 = head1;
		ListNode iterator2 = head2;
		
		while(iterator1 != null){
			len1++;
			iterator1 = iterator1.next;
		}
			
		while(iterator2 != null){
			len2++;
			iterator2 = iterator2.next;
		}
		
		iterator1 = head1;
		iterator2 = head2;
		
		int diff = len1 - len2;
		
		if(diff > 0){
			while(diff != 0){
				iterator1 = iterator1.next;
				diff--;
			}
		}
		else{
			diff = -1 * diff;
			while(diff != 0){
				iterator2 = iterator2.next;
				diff--;
			}
		}
		
		while(iterator1.data != iterator2.data){
			iterator1 = iterator1.next;
			iterator2 = iterator2.next;
		}
		
		return iterator1;
		
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
