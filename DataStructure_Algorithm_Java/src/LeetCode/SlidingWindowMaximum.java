package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
	public static void main(String args[]){
		int arr[] = {1,3,-1,-3,5,3,6,7};
		System.out.println(findMinWindowMaximum(arr,3));
		
	}
	public static int findMinWindowMaximum(int arr[], int k){
		int max = Integer.MIN_VALUE;
		Deque<Integer> deq = new ArrayDeque<>();
		for(int i =0 ; i<k ; i++){
			while(!deq.isEmpty() && arr[i]<= arr[deq.peekLast()])
				deq.pollLast();
			deq.addLast(i);
		}
		for(int i = k; i< arr.length ;i++){
			max = max>arr[deq.peekFirst()]?max :arr[deq.peekFirst()];
			
			while(!deq.isEmpty() && arr[i] <= arr[deq.peekLast()])
				deq.pollLast();
			
			while(!deq.isEmpty() && i-k >= deq.peekFirst())
				deq.pollFirst();
			
			deq.addLast(i);
		}
		
		max = max>arr[deq.peekFirst()]?max :arr[deq.peekFirst()];
		
		return max;
	}
}
