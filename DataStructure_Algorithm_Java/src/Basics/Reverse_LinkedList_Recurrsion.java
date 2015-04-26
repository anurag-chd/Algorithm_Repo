package Basics;

public class Reverse_LinkedList_Recurrsion {
	
	public static void main(String args[]){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		Node <Integer> temp = null;
		temp =inverseList(list.head,temp);
		//inverseList(list.head,temp);
		System.out.println("The reverse List");
		Node root = temp;
		while(root != null){
			System.out.println(root.getvalue());
			root = root.getNext();
		}
		
	}
	
	public static Node inverseList(Node root, Node temp){
		if(root.getNext() == null){
			temp = root;
			return temp;
			
		}
		
		temp = inverseList(root.getNext(),temp);
		
		//temp =insertNode(temp,root);
		insertNode(temp,root);
		return temp;
		
	}
	
	public static void insertNode(Node inverse_root,Node n){
		System.out.println(inverse_root.getvalue());
		Node temp2 = inverse_root;
		while(temp2.getNext()!=null){
			System.out.println(temp2.getvalue());
			temp2 = temp2.getNext();
		}
		temp2.setNext(n);
		n.setNext(null);
		//return inverse_root;
	}
}


