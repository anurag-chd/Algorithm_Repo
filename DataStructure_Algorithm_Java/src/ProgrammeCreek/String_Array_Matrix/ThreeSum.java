package ProgrammeCreek.String_Array_Matrix;

import java.util.Collections;

import Vmware.QuickSort;

public class ThreeSum {
	public static void main(String args[]){
		int arr[] = {-1, 0, 1, 2, -1,-4};
		
		findTriplets(arr);
		
	}
	
	public static void findTriplets(int arr[]){
		QuickSort.sort(arr,0,arr.length-1);
		
		for(int index =0 ; index < arr.length-2 ;index++){
			int a = arr[index] * -1;
			int start = index+1;
			int end = arr.length-1;
			while(start<end){
				if(a == arr[start] + arr[end]){
					System.out.println("("+arr[index]+" ,"+arr[start]+" ,"+ arr[end]+")");
					break;
				}
				else if(a > arr[start] + arr[end])
					start++;
				else
					end--;
			}
		}
	}
	
	
}
