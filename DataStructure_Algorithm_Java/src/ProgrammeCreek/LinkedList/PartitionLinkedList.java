package ProgrammeCreek.LinkedList;

public class PartitionLinkedList {
	public static void main(String args[]){
		ListNode l1 = new ListNode(2);
		l1.next =new ListNode(1);
		/*l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(2);
		l1.next.next.next.next = new ListNode(5);
		l1.next.next.next.next.next= new ListNode(2);*/
		printList(l1);
		l1 = partition(l1, 2);
		printList(l1);
	}
	
	public static ListNode partition(ListNode head, int x){
		if(head == null || head.next == null){
			return head;
		}
		ListNode nextBiggerNode = null;
		ListNode parent = head;
		ListNode child = head;
		boolean biggerFlag = false, firstNode = false;
		while(child != null){
			if(child.val >= x && !biggerFlag){
				if(parent == child){
					firstNode = true;
					child = child.next;
					nextBiggerNode = parent;
				}
				else{
					nextBiggerNode = parent;
					firstNode = false;
					child = child .next;
					parent = parent.next;
				}
				biggerFlag = true;
			}
			else if(child.val < x && biggerFlag){
				parent.next = child.next;
				if(firstNode){
					child.next = nextBiggerNode;
					nextBiggerNode = child;
					head = child;
					firstNode = false;
				}
				else{
					ListNode temp = nextBiggerNode.next;
					nextBiggerNode.next = child;
					child.next = temp;
					nextBiggerNode = child;
				}
				child = parent.next;
			}
			else{
				if(parent == child){
					child = child.next;
				}
				else{
					parent = parent.next;
					child = child.next;
				}
				
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
