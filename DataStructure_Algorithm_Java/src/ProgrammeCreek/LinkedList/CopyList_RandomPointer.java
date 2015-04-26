package ProgrammeCreek.LinkedList;

public class CopyList_RandomPointer {
	public static void main(String args[]){
		RandomListNode one = new RandomListNode(1);
		RandomListNode two = new RandomListNode(2);
		RandomListNode three = new RandomListNode(3);
		RandomListNode four = new RandomListNode(4);
		one.next = two;
		two.next = three;
		three.next = four;
		one.random = three;
		two.random = four;
		three.random = two;
		four.random = one;
		
		RandomListNode head = copyRandomList(one);
		
		
	}
	
	public static RandomListNode copyRandomList(RandomListNode head){
		if(head == null){
			return null;
		}
		
		// traverse the list and insert copy between two adjacent nodes
		
		RandomListNode itr = head;
		while(itr.next!=null){
			RandomListNode temp = itr.next;
			itr.next = new RandomListNode(itr.label);
			itr.next.next = temp;
			itr = temp;
		}
		itr.next = new RandomListNode(itr.label);
		
		// set random pointers of the copied list
		itr = head;
		while(itr.next.next != null){
			itr.next.random = itr.random.next;
			itr = itr.next.next;
		}
		
		// serperate the new copied list
		itr = head;
		RandomListNode resultListNode = itr.next;
		RandomListNode temp = itr.next;
		while(temp.next != null){
			itr.next = temp.next;
			temp.next = temp.next.next;
			itr = itr.next;
			temp = temp.next;
		}
		
		return resultListNode;
		
	}
}

class RandomListNode {
	 int label;
	 RandomListNode next, random;
	 RandomListNode(int x) { this.label = x; }
	  };
