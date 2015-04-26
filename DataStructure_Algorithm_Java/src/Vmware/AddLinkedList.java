package Vmware;

import Basics.LinkedList;
import Basics.Node;

public class AddLinkedList {
	static int carry =0;
	public static void main(String args[]){
		LinkedList<Integer> num1 = new LinkedList<Integer>();
		LinkedList<Integer> num2 = new LinkedList<Integer>();
		num1.insert(9);
		num1.insert(2);
		num1.insert(3);
		num1.insert(4);
		num2.insert(9);
		num2.insert(9);
		num2.insert(9);
		
		
		Node head = add(num1,num2);
		
	}
	
	
	public static Node add(LinkedList num1,LinkedList num2){
		int l1 = len(num1);
		int l2 = len(num2);
		System.out.println(l1+" "+l2);
		
		if(num1 ==null)
			return num1.getHead();
		if(num2 == null)
			return num2.getHead();
		
		if(l1>l2)
			paddList(num2,l1-l2);
		else{
			paddList(num1,l2-l1);
		}
		l1 = len(num1);
		l2 = len(num2);
		System.out.println(l1+" "+l2);
		
		Node temp = addList(num1.getHead(),num2.getHead());
		if(carry>0){
			Node temp2 = new Node(carry);
			temp2.setNext(temp);
			temp = temp2;
		}
		Node result = temp;
		System.out.println(carry);
		while(result!=null){
			System.out.print(result.getvalue()+"-");
			result = result.getNext();
		}
		
		
		return temp;
		
	}
	
		
	public static Node addList(Node num1, Node num2){
		if(num1 == null){
			return null;
		}
		else{
			//System.out.println(carry);
			Node result = new Node(0);
			result.setNext(addList(num1.getNext(),num2.getNext()));
			int sum = 0;
			sum = (Integer)num1.getvalue()+(Integer)num2.getvalue()+ carry;
			System.out.println(sum);
			if(sum >=10){
				carry = sum/10;
				sum = sum%10;
				//System.out.println(carry);
			}
			
			else{
				carry =0;
			}
			result.setvalue(sum);
			
			return result;
		}
		
	}
	
	
	public static void paddList(LinkedList l , int count){
		if(count ==0)
			return;
		for(int i =0 ; i< count;i++){
			Node n = new Node(0);
			n.setNext(l.getHead());
			l.setHead(n);
		}
		
	}
	
	public static int len(LinkedList l){
		if(l == null){
			return 0;
		}
		Node head = l.getHead();
		int result =1;
		while(head!=null){
			head= head.getNext();
			result++;
		}
		return result;
		
	}
}
