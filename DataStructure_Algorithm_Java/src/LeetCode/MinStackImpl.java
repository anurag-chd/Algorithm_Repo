package LeetCode;

import java.util.Stack;

public class MinStackImpl {
	public static void main(String args[]){
		MinStack ms = new MinStack();
		ms.push(2);
		ms.push(0);
		ms.push(3);
		ms.push(0);
		System.out.print(ms.getMin()+" ,");
		ms.pop();
		System.out.print(ms.getMin()+" ,");
		ms.pop();
		//ms.push(-20);
		System.out.print(ms.getMin()+" ,");
		ms.pop();
		System.out.print(ms.getMin()+" ,");
		/*System.out.print(ms.top()+" ,");
		System.out.print(ms.getMin()+" ,");
		ms.pop();
		ms.push(10);
		ms.push(-7);
		System.out.print(ms.getMin()+" ,");
		ms.push(-7);
		ms.pop();
		System.out.print(ms.top()+" ,");
		System.out.print(ms.getMin()+" ,");
		System.out.print(ms.top()+" ,");*/
	}

}

class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x < minStack.peek())
            minStack.push(x);
    }

    public void pop() {
        if(stack.isEmpty())
            return;
        int x = stack.pop();
        
        if(stack.isEmpty()){
            minStack.pop();
        }
        else if(x == minStack.peek() && x > stack.peek()){
            minStack.pop();
        }
        else if(x == minStack.peek() && (stack.size()+1 == minStack.size())){
            minStack.pop();
        }
            
        
    }

    public int top() {
        return stack.peek();
        
    }

    public int getMin() {
        return minStack.peek();
    }
}
