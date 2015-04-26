package EPIC;

import java.util.ArrayList;

public class EnumerateAnagram_WO_Moving_Caps_Number {
	public static void main(String args[]){
		String str = "q1eRz";
		System.out.println(getAnagrams(str));
	}
	
	public static ArrayList<String> getAnagrams(String str){
		if(str == null || str.length() == 0)
			return null;
		ArrayList<String> result = new ArrayList<>();
		if(str.length() == 1){
			result.add(str);
			return result;
		}
		StringBuilder sbr = new StringBuilder();
		ArrayList<ArrayList<Integer>> indexList = new ArrayList<>();
		ArrayList<Integer> startList = new ArrayList<>();
		for(int i = 0; i< str.length() ; i++){
			if((int)str.charAt(i)- (int)'a' >=0  && (int)str.charAt(i)- (int)'a' < 26){
				sbr.append(" ");
				startList.add(i);
			}
				
			else
				sbr.append(str.charAt(i));
		}
		indexList.add(startList);
		
		for(int i = startList.size()-2 ;i >= 0;i--){
			ArrayList<ArrayList<Integer>> copyList = new ArrayList<>();
			for(ArrayList<Integer> l : indexList){
				for(int j = i+1; j < startList.size() ;j++){
					ArrayList<Integer> temp = new ArrayList<>();
					temp.addAll(l);
					swap(temp,i,j);
					copyList.add(temp);
				}
			}
			indexList.addAll(copyList);
		}
		
		for(ArrayList<Integer> l : indexList){
			StringBuilder s = new StringBuilder();
			int j = 0;
			for(int i = 0; i< str.length(); i++){
				if(sbr.charAt(i) != ' ')
					s.append(sbr.charAt(i));
				else{
					s.append(str.charAt(l.get(j)));
					j++;
				}
			}
			result.add(s.toString());
		}
		
		return result;
	}
	
	public static void swap(ArrayList<Integer> list, int i, int j){
		int temp1 = list.get(i);
		int temp2 = list.get(j);
		list.remove(i);
		list.remove(j-1);
		list.add(i,temp2);
		
		list.add(j,temp1);
	}
	
}
