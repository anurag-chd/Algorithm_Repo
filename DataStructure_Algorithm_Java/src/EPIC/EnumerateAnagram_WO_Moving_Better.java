package EPIC;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EnumerateAnagram_WO_Moving_Better {
	public static void main(String args[]){
		String str = "q1eRz";
		reorderString(str);
	}
	
	public static void reorderString(String str){
		if(str == null || str.length() <2){
			System.out.println(str);
			return;
		}
		List<String> list = new ArrayList<>();
		list.add(str);
		int index = str.length()-1;
		boolean lastChar = false;
		
		while(index>=0){
			List<String> tempList = new ArrayList<>();
			for(String s : list){
				char c = s.charAt(index);
				if(c >='a' && c <='z' && lastChar){
					 
					tempList.addAll(addAnagram(s,index));
					
				}
				else if(c >='a' && c <='z' && !lastChar){
					lastChar = true;
				}
			}
			if(tempList != null){
				list.addAll(tempList);
			}
			index--;
		}
		
		System.out.println(list);
			
	}
	
	public static List<String> addAnagram(String str, int index){
		
		List<String> list = new ArrayList<>();
		for(int i = index+1; i<str.length();i++){
			char arr[] = str.toCharArray();
			if(arr[i]>= 'a' && arr[i] <='z'){
				char temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				list.add(new String(arr));
			}
		}
		return list;
		
		
	}
	
}
