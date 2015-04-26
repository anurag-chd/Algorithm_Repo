package AmazonInterview;

import Basics.LinkedList;
import Basics.Node;

public class LinkedList_Common_Index {
	
	public static void main(String args[]){
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		l1.insert(1);
		l1.insert(2);
		l1.insert(3);
		l1.insert(4);
		l1.insert(4);
		l1.insert(5);
		l1.insert(6);
		
		l2.insert(7);
		l2.insert(8);
		l2.insert(4);
		l2.insert(5);
		l2.insert(6);
		
		int result =getCommonIndex(l1,l2);
		System.out.println(result);
	}
	
	
	public static int getCommonIndex(LinkedList l1, LinkedList l2){
		int len1 =0;
		int len2 =0;
		Node root1 = l1.getHead();
		Node root2 = l2.getHead();
		Node temp1 = root1;
		Node temp2 = root2;
		
		while(temp1 != null){
			len1++;
			temp1 = temp1.getNext();
		}
		
		while(temp2 != null){
			len2++;
			temp2 = temp2.getNext();
		}
		int d;
		if(len1>len2){
			d = len1-len2;
			while(d>0){
				root1 = root1.getNext();
				d--;
			}
		}
		else{
			d = len2 - len1;
			while(d>0){
				root2 = root2.getNext();
				d--;
			}
		}
		
		int result = getIndex(root1, root2, true);
		return result;
	}
	
	public static int getIndex(Node root1, Node root2, boolean flag){
		
		if(root1 == null || root2 == null){
			return 0;
		}
		else{
		int count =	getIndex(root1.getNext(),root2.getNext(),flag);
			if(root1.getvalue() == root2.getvalue() && flag == true){
				System.out.println(root1.getvalue());
				return ++count;
			}
			else{
				flag = false;
				return count;
			}
			
		}
	}
	
	
}
