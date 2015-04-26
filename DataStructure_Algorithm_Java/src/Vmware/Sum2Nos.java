package Vmware;

import java.util.*;

public class Sum2Nos {
	public static void main(String args[]){
		int arr[] ={2,4,3,6,10};
		findPair(arr, 1);
	}
	public static void findPair(int arr[], int sum){
		
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i : arr)
			set.add(i);
		int count = 0;
		for(int i : set){
			int j = sum -i;
			if(set.contains(j)){
				System.out.println(" the numbers are "+i+"  "+j);
				count ++;
				return;
			}
			else{
				if(count == set.size()-2){
					System.out.println("No such pair");
					return;
				}
				else{
					count++;
				}
			}
		}
	}
	

}
