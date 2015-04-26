package Geek4Geeks_Strings;

import java.util.Arrays;

public class PrintAllAnagrams {
	public static void main(String args[]){
		String str_arr[] = {"cat", "dog", "tac", "god", "act"};
		printAllAna(str_arr);
 		
	}
	
	public static void printAllAna(String str_arr[]){
		int n = str_arr.length;
		String sorted_arr[] = new String[n];
		Integer index_arr [] = new Integer[n];
		for(int i = 0; i < n ;i++){
			index_arr[i] = i;
			sorted_arr[i] = sortString(str_arr[i]);
		}
		System.out.println(sorted_arr[1]);
		int i =0;
		int k =0;
		while(i<n-1){
			int j = i+1;
			while(j<n){
				
				if(sorted_arr[i].equals(sorted_arr[j])){
					if(k ==0){
						i++;
						j = i+1;
					}
					else{
						System.out.println("k= "+k+" j= "+j +" i ="+i);
						swap(index_arr,j,k);
						swap(sorted_arr,j,k);
						for(int a =0; a<n ;a++){
							System.out.print(sorted_arr[a]+" ,");
						}
						System.out.println();
						i++;
						j = i +1;
						k = 0;
					}
				}
				else{
					
					if(k ==0)
						k =j;
					j++;
				}
			}
		k=0;
		i++;
		}
		for(int a =0; a<n ;a++){
			System.out.print(sorted_arr[a]+" ,");
		}
		System.out.println();
		for(int a =0; a<n ;a++){
			System.out.print(str_arr[index_arr[a]]+" ,");
		}
		
	}
	
	public static <T> void swap( T arr[], int i , int k){
		T temp = arr[i];
		arr[i] = arr[k];
		arr[k] = temp;
		
	}
	
	public static String sortString(String str){
		char char_arr [] = str.toCharArray();
		StringBuilder sbr = new StringBuilder();
		Arrays.sort(char_arr);
		for(int i = 0; i< char_arr.length;i++){
			sbr.append(char_arr[i]);
		}
		return sbr.toString();
	}
}


