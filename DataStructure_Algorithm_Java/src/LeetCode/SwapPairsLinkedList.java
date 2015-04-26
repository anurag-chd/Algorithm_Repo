package LeetCode;

public class SwapPairsLinkedList {
	public static boolean swap = false;
	
	public static void main(String args[]){
		Listnode head = new Listnode(1);
		head.next = new Listnode(2);
		//head.next.next = new Listnode(3);
		//head.next.next.next = new Listnode(4);
		
		printList(head);
		
		Listnode newHead = swapPairs(head);
		
		printList(newHead);
				
	}
	
	
	public static Listnode swapPairs(Listnode head){
		if(head == null || head.next == null)
			return head;
		Listnode parent = head , child = head.next;
		Listnode newHead = child;
		Listnode swapHead = null; 
		while(child != null){
			if(!swap){
				parent.next = child.next;
				child.next = parent;
				swapHead = parent;
				child = parent.next;
				swap = true;
			}
			else{
				if(child.next == null)
					return newHead;
				parent = parent.next;
				swapHead.next = parent.next;
				child = child.next;
				swap = false;
			}
		}
		
		return newHead;
		
	}
	
	public static Listnode swapList(Listnode parent, Listnode child , Listnode newHead){
		if(child.next == null){
			parent.next = child.next;
			child.next = parent;
			newHead = child;
			swap = true;
			return newHead;
		}
		newHead = swapList(parent.next,child.next,newHead);
		if(swap){
			parent.next = newHead;
			swap = false;
			newHead = parent;
			return newHead;
		}
		else{
			parent.next = child.next;
			child.next = parent;
			newHead = child; 
			swap = true;
			return newHead;
			
		}
		
		
	}
	
	public static void printList(Listnode head){
		if(head == null)
			return;
		Listnode temp = head;
		while(temp != null){
			System.out.print(temp.val + " ,");
			temp = temp.next; 
		}
		System.out.println();
		
	}
	
}

class Listnode {
	int val;
	Listnode next;
	Listnode(int x){
		val = x;
		next = null;
	}
}
