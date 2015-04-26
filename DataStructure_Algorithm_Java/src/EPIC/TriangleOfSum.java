package EPIC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TriangleOfSum {
	public static void main(String args[]){
		int arr[] = {4, 7, 3, 6, 7};
		printTriangle(arr);
	}
	
	public static void printTriangle(int arr[]){
		List<Integer> givenList = new ArrayList<>();
		for(int i : arr)
			givenList.add(i);
		ArrayList<List<Integer>> result = new ArrayList<>();
		result.add(givenList);
		while(givenList.size()>1){
			List<Integer> temp = new ArrayList<>();
			for(int i =0; i< givenList.size()-1;i++)
				temp.add((givenList.get(i)+givenList.get(i+1)));
			result.add(temp);
			givenList = temp;
		}
		
		printTri(result);
	}
	
	public static void printTri(ArrayList<List<Integer>> list){
		int index = list.size()-1;
		while(index >=0){
			System.out.print("{{");
			for(int i: list.get(index))
				System.out.print(i+",");
			System.out.println("}}");
			index--;
		}
	}

}
