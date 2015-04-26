package Vmware;

import DataStructure.Stack;

public class StackSort {
	public static void main(String args[]){
		Stack<Integer> s = new Stack<Integer>();
		s.push(7);
		s.push(5);
		s.push(8);
		s.push(10);
		s.push(15);
		Stack<Integer> sort_stack = sort(s);
		while(!sort_stack.isEmpty()){
			System.out.println(sort_stack.pop());
		}
		
	}
	
	public static Stack sort(Stack<Integer> stack){
		Stack<Integer> r = new Stack<Integer>();
		while(!stack.isEmpty()){
			int temp = stack.pop();
			while(!r.isEmpty() && (int)r.peek().getvalue()>temp){
				stack.push(r.pop());
			}
			r.push(temp);
		}
		return r;
	}
}
