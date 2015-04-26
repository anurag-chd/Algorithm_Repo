package LeetCode;

public class ReverseLinkedListII {
	public static void main(String args[]){
		Listnode head = new Listnode(1);
		head.next = new Listnode(2);
		head.next.next = new Listnode(3);
		head.next.next.next = new Listnode(4);
		head.next.next.next.next = new Listnode(5);
		head.next.next.next.next.next = new Listnode(6);
		
		printList(head);
		Listnode newHead = reverseBetween(head, 2,4);
		printList(newHead);
	}
	
	public static void printList(Listnode head){
		Listnode temp = head;
		while(temp!=null){
			System.out.print(temp.val+" ,");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static Listnode reverseBetween(Listnode head, int m , int n){
		int listSize = getListSize(head);
		if(m >listSize  || n>listSize)
			return null;
		Listnode parent = null;
		Listnode temp = head;
		int count = 1;
		while(count< m){
			parent = temp;
			temp = temp.next;
			count++;
		}
		if(m == 1){
			return revList(temp, m, n);
		}
		else{
			parent.next = revList(temp, m, n);
			return head;
		}
		
	}
	
	public static Listnode revList(Listnode head, int m, int n){
		if(m == n)
			return head;
		Listnode prev = head;
		Listnode curr = head.next;
		Listnode newHead = null; 
		newHead = rev(prev,curr,m+1,n,newHead);
		return newHead;
	}
	
	public static Listnode rev(Listnode prev, Listnode curr, int m , int n , Listnode result){
		if(m == n){
			prev.next = curr.next;
			curr.next = prev;
			result = curr;
			return result;
		}
		result =rev(prev.next, curr.next, m+1, n, result);
		prev.next = curr.next;
		curr.next = prev;
		return result;
	}
	
	
	public static int getListSize(Listnode head){
		Listnode temp = head;
		int count =0;
		while(temp != null){
			count++;
			temp = temp.next;
		}
		return count;
		
	}
}
