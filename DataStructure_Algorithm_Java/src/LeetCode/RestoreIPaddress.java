package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPaddress {
	public static void main(String args[]){
		String str = "0000";
		
		System.out.println(restoreIpAddress(str));
	}
	
	public static List<String> restoreIpAddress(String str){
		if(str == null || str.length()<4 || str.length() >12)
			return null;
		List<String> result = new ArrayList<>();
		String s = "";
		getAllIps(str,0,0,s,result);
		return result;
	}
	
	public static void getAllIps(String str, int index,int part, String s, List<String> result){
		if(index == str.length() && part ==4){
			s = s.substring(0, s.length()-1);
			result.add(s);
			return;
		}
		if(index > str.length())
			return;
		if(part>3)
			return;
		for(int i = 0 ; i<= 3; i++){
			if(index +i < str.length() && Integer.valueOf(str.substring(index,index+i+1))<=255){
				if((i ==1 && Integer.valueOf(str.substring(index,index+i+1))>9) ||
			              (i ==2 && Integer.valueOf(str.substring(index,index+i+1))>99)){
			      
			        s = s+str.substring(index,index +i+1)+".";
			        getAllIps(str,index+i+1,part+1,s,result);
				    s = s.substring(0,s.length()-1);
				    s = s.substring(0,s.lastIndexOf(".")+1);    
			    }
			}
			
		}
	}
}
