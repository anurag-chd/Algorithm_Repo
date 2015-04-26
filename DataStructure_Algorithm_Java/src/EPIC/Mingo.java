package EPIC;


import java.util.HashSet;
import java.util.Set;

public class Mingo {
	public static void main(String args[]){
		int arr[][] ={	{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                		{11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
                		{21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
                		{31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
                		{41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
                		{51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
                		{61, 62, 63, 64, 65, 66, 67, 68, 69, 70},
                		{71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
                		{81, 82, 83, 84, 85, 86, 87, 88, 89, 90},
                		{91, 92, 93, 94, 95, 96, 97, 98, 99, 100}
					};
		
		int count[] = {1, 2, 3, 4, 73, 82, 91, 5, 6, 7, 8, 9, 10};
		System.out.println(isMingo(arr,count));
		
	}
	
	public static boolean isMingo(int arr[][], int count[]){
		if(count.length < arr.length)
			return false;
		int row[] = new int[arr.length];
		int col[] = new int[arr[0].length];
		int diag[] = new int[2];
		Set<Integer> set = new HashSet<>();
		for(int i : count)
			set.add(i);
		
		for(int i = 0; i< arr.length; i++){
			for(int j = 0; j < arr[0].length ;j++){
				if(set.contains(arr[i][j])){
					row[i]++;
					col[j]++;
					if(i == j)
						diag[0]++;
					else if(i+j == arr.length-1)
						diag[1]++;
					if(row[i] == arr.length || col[j] == arr[0].length || diag[0] == arr[0].length || diag[1] == arr[0].length)
						return true;
					
				}
			}
		}
		return false;
	}
}
