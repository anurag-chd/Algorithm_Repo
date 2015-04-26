package PracticeQues;

import java.util.HashMap;
import java.util.Map;

public class PrintKeyStroke_Strings {
	public static void main(String args[]){
		Map<String,String> map = new HashMap<>();
		map.put("1", "abc");
		map.put("2", "def");
		map.put("3", "xyz");
		
		String keyStroke = "123";
		
		printAllCombo(keyStroke,map);
		
		
	}
	
	public static void printAllCombo(String keyStroke, Map<String,String> map){
		char arr[] = new char[keyStroke.length()];
		
		print(keyStroke,map,arr,0);
	}
	
	public static void print(String keyStroke, Map<String,String> map,char arr[], int index){
		if(index == keyStroke.length()){
			printArr(arr);
			return;
		}
		String key = keyStroke.substring(index,index+1);
		char [] value = map.get(key).toCharArray();
		for(int i =0; i<value.length; i++){
			arr[index] = value[i];
			print(keyStroke,map,arr,++index);
			index--;
		}
		
	}
	
	public static void printArr(char arr[]){
		for(char c: arr)
			System.out.print(c);
		System.out.println();
	}
}

