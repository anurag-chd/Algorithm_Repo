package LeetCode;

public class ZigZagConversion {
	public static void main(String args[]){
		String str = "ABCD";
		System.out.println(convert(str,3));
	}
	
	public static String convert(String str, int rows){
		if(str == null || str.length() == 0 || str.length() == rows || rows < 2)
			return str;
		String [] strArr = new String[rows];
		for(int i =0 ; i< strArr.length; i++)
			strArr[i] = new String("");
		
		int count = 0;
		boolean flag = true;
		for(int i = 0; i< str.length();i++){
			if(flag){
				strArr[count] = strArr[count] + str.substring(i,i+1);
				count++;
				if(count == rows){
				    flag = false;
					count = count -2;
				}
			}
			else{
				strArr[count] = strArr[count] + str.substring(i,i+1);
				count--;
				if(count == 0)
					flag = true;
			}
		}
		
		StringBuilder sbr = new StringBuilder();
		for(String s: strArr)
			sbr.append(s);
		
		return sbr.toString();
	}
}
