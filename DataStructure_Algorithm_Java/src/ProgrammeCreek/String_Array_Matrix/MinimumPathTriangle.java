package ProgrammeCreek.String_Array_Matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumPathTriangle {
	public static void main(String args[]){
		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> temp1 = new ArrayList<>();
		temp1.add(-1);
		List<Integer> temp2 = new ArrayList<>();
		
		temp2.add(2);temp2.add(3);
		List<Integer> temp3 = new ArrayList<>();
		temp3.add(1);temp3.add(-1);temp3.add(-3);
		List<Integer> temp4 = new ArrayList<>();
		temp4.add(1);temp4.add(8);temp4.add(3);temp4.add(4);
		triangle.add(temp1);
		triangle.add(temp2);
		triangle.add(temp3);
		//triangle.add(temp4);
				
		System.out.println(minimumTotal(triangle));
	}
	
	public static int minimumTotal(List<List<Integer>> triangle){
		if(triangle == null)
			return 0;
		//  take the last row of the triangle and fill the min_sum array
		int l = triangle.size()-1;
		int min_sum [] = new int[triangle.size()];
		for(int i =0; i< min_sum.length;i++)
			min_sum[i]= triangle.get(l).get(i);
		
		//Integer min_sum[] = triangle.get(triangle.size()-1).toArray(new Integer[triangle.get(triangle.size()-1).size()]);
		
		
		// traverse upwards from the 2nd last array
		for(int index = triangle.size()-2; index>=0;index --){
			for(int minIndex = 0 ; minIndex< triangle.get(index).size() ; minIndex++){
				min_sum[minIndex] = triangle.get(index).get(minIndex) + min_sum[minIndex]>min_sum[minIndex+1]?min_sum[minIndex+1]:min_sum[minIndex];
			}
		}
		return min_sum[0];
	}
	
	
}
