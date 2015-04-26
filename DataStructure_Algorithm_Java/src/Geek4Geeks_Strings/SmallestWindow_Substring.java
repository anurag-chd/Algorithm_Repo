package Geek4Geeks_Strings;

public class SmallestWindow_Substring {
	public static void main(String args[]){
		String str1 = "this is a test string";
		String str2 = "tist";
		getWindow(str1,str2);
	}
	
	public static void getWindow(String str1, String str2){
		int char_arr1[] = new int[256];
		int char_arr2[] = new int[256];
		for(int i =0;i< 256;i++){
			char_arr1[i] = 0;
			char_arr2[i] = 0;
		}
		char str1_arr[] = str1.toCharArray();
		char str2_arr[] = str2.toCharArray();
		for(int i = 0 ; i< str2.length();i++){
			
			char_arr2[(int)((char)str2_arr[i])] = char_arr2[(int)((char)str2_arr[i])] +1;
			
				
		}
		int str2_len = str2.length();
		int count = 0;
		String min_str = str1;
		String temp = "";
		int j =0;
		boolean first_win = false;
		for(int i = 0; i< str1.length(); i++){
			
			if(char_arr2[(int)(char)str1_arr[i]]>0){
				
				if(char_arr1[(int)(char)str1_arr[i]] < char_arr2[(int)(char)str1_arr[i]])
					count++;
				char_arr1[(int)(char)str1_arr[i]] = char_arr1[(int)(char)str1_arr[i]] + 1;
				
				if(count == 1){
					temp = str1.substring(i);
				}
				else if(count == str2_len && !first_win ){
					temp = temp.substring(0,i+1-j);
					System.out.println(temp);
					if(min_str.length()>temp.length()){
						min_str = temp;
					}
					first_win = true;
				}
				else if(str1_arr[i] == temp.charAt(0) && count == str2_len){
					temp = temp + str1_arr[i];
					
					
					temp = trim(temp,char_arr1,char_arr2);
					System.out.println(temp);
					if(min_str.length()>temp.length())
						min_str = temp;
				}
				else if(count == str2_len){ 
					temp = temp + str1_arr[i];
					
				}
				
			}
			else{
				if(count == 0)
					j++;
				if(count == str2_len){
					temp = temp + str1_arr[i];
				}
			}
		}
		System.out.println(min_str);
		
	}
	
	
	public static String trim(String str,int char_arr1[], int char_arr2[]){
		for(int i =0;i< 256;i++)
			char_arr1[i] = 0;
		
		str = str.substring(1);
		for(int k =0;k<str.length();k++ ){
			char_arr1[(int)str.charAt(k)] = char_arr1[(int)str.charAt(k)] + 1;
		}
		for(int i =0; i< str.length();i++){
			
			if(char_arr2[(int)(char)str.charAt(i)] == 0){
				str = str.substring(1);
				i--;
			}
			else if(char_arr2[(int)(char)str.charAt(i)] > 0 && char_arr2[(int)(char)str.charAt(i)] != char_arr1[(int)(char)str.charAt(i)]){
				char_arr1[(int)(char)str.charAt(i)] = char_arr1[(int)(char)str.charAt(i)] -1;
				System.out.println(char_arr1[(int)(char)str.charAt(i)]+"   "+ char_arr2[(int)(char)str.charAt(i)]);
				System.out.println(str.charAt(1));
				str = str.substring(1);
				i--;
				System.out.println("Hii3 "+str);
			}
			else if(char_arr2[(int)(char)str.charAt(i)] > 0 && char_arr2[(int)(char)str.charAt(i)] == char_arr1[(int)(char)str.charAt(i)]){
				return str;
			}
			
		}
		return str;
	}
}
