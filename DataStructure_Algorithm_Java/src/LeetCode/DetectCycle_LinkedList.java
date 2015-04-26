package LeetCode;

import Basics.LinkedList;

public class DetectCycle_LinkedList {
	public static void main(String args[]){
		List_Node one = new List_Node(1);
		List_Node two = new List_Node(2);
		List_Node three = new List_Node(3);
		List_Node four = new List_Node(4);
		List_Node five = new List_Node(5);
		List_Node six = new List_Node(6);
		List_Node seven = new List_Node(7);
		List_Node eight = new List_Node(8);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = seven;
		seven.next = eight;
		eight.next = three;
		
		List_Node result =findCycle(one);
		if(result == null){
			System.out.println("There is no cycle");
		}
		else{
			System.out.println("Cycle is at "+ result.val);
		}
				
	}
	
	public static List_Node findCycle(List_Node head){
		if(head == null){
			return null;
		}
		List_Node single_hop = head;
		List_Node double_hop = head;
		
		single_hop = single_hop.next;
		double_hop = double_hop.next.next;
		
		while(single_hop.val != double_hop.val){
			double_hop = double_hop.next.next;
			single_hop = single_hop.next;
			if(double_hop == null){
				System.out.println("List has no cycle");
				return null;
			}
		}
		
		List_Node result = head;
		while(result != single_hop){
			result = result.next;
			single_hop = single_hop.next;
		}
		return result;
		
		
	}
	
	

}
class List_Node {
	      int val;
	      List_Node next;
	      List_Node(int x) {
	          val = x;
	          next = null;
	      }
	  }
