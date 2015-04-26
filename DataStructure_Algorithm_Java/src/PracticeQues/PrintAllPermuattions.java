package PracticeQues;

import java.util.ArrayList;

public class PrintAllPermuattions {
	public static void main(String args[]){
		String str = "abc";
		ArrayList<String> list = new ArrayList<>();
		printPerms(str,list,0);
		System.out.println(list);
		
	}
	
	public static void printPerms(String str, ArrayList<String> list , int index){
		if(index == str.length()){
			list.add(" ");
			return;
		}
		else{
			printPerms(str,list,index+1);
			ArrayList<String> temp = new ArrayList<String>(list);
			String s = str.substring(index, index+1);
			for(String list_string : temp){
				if(list_string.equals(" ")){
					list.add(s);
				}
				else{
					for(int i =0; i<=list_string.length(); i++){
						String prefix = list_string.substring(0,i);
						String suffix = list_string.substring(i);
						
						list.add(prefix+s+suffix);
					}
				}
			}
			temp = null;
			return;
		}
		
	}
}
