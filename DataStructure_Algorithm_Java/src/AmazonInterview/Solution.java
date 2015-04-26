package AmazonInterview;

import java.io.*;

public class Solution {
	public static void main(String args[]) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String line = br.readLine();
		 int result = shortPalin(line);
		 System.out.println(result);
		
	}
	public static int shortPalin(String S) {
		char[] arr = S.toCharArray();
		int result = MinInsertion(arr,0, arr.length-1);
		return result;
		
	}
	
	public static int MinInsertion(char str[], int start, int end)
	{
	    
	    if (start == end){
	    	return 0;
	    }
	    if (start == end - 1){
	    	if(str[start] == str[end])
	    		return 0;
	    	else
	    		return 1;
	    }
	 

	    if(str[start] == str[end]){
	    	return MinInsertion(str, start + 1, end - 1);
	    }
	    else{
	    	return (Math.min(MinInsertion(str, start, end - 1),MinInsertion(str, start + 1, end)) + 1);

	    }

	}
	
	
	
}
