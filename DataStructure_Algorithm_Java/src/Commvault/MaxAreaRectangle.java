package Commvault;

import java.util.Stack;

public class MaxAreaRectangle {
	public static void main(String args[]){
		int arr[] = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(arr));
	}
	
	public static int largestRectangleArea(int[] height){
		if(height == null || height.length == 0)
			return 0;
		Stack<Integer> stack = new Stack<>();
		int i =0;
		int tp, currArea ,maxArea =0;
		 
		while(i< height.length){
			if(stack.isEmpty() || height[stack.peek()] <= height[i])
				stack.push(i++);
			else{
				tp = stack.pop();
				currArea = height[tp] * (stack.size() == 0?i: i - stack.peek() - 1);
				maxArea = maxArea>currArea?maxArea:currArea;
			}
		}
		
		while(!stack.isEmpty()){
			tp = stack.pop();
			currArea = height[tp] * (stack.size() == 0?i: i - stack.peek() - 1);
			maxArea = maxArea>currArea?maxArea:currArea;
		}
		
		return maxArea;
	}
}
