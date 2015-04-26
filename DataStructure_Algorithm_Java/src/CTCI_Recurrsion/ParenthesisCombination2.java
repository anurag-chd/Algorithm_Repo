package CTCI_Recurrsion;

import java.util.*;
public class ParenthesisCombination2 {
	public static void main(String args[]){
		int num_paren = 2;
		/*ArrayList<String> list = new ArrayList<String>();
		ParenthesisCombination2 pc2 = new ParenthesisCombination2();
		list = pc2.getParenthesis(num_paren);*/
		
		System.out.println(generateParenthesis(num_paren));
		/*for(String s :list){
			System.out.println(s);
		}*/
		
		
	}
	public static List<String> generateParenthesis(int n) {
        if(n <1)
            return null;
        List<String> result = new ArrayList<>();
        char []strCharArr = new char[n*2];
        getParenth(0,strCharArr,result,n,n);
        return result;
        
    }
    
    public static void getParenth(int n , char[]arr , List<String> result , int leftBraces, int rightBraces){
        if(leftBraces<0 || rightBraces < leftBraces)
            return;
        if(leftBraces == 0 && rightBraces == 0){
            String str = new String(arr);
            result.add(str);
        }
        if(leftBraces > 0){
            arr[n] = '(';
            getParenth(n+1,arr,result,leftBraces-1,rightBraces);
        }
        if(rightBraces > 0){
            arr[n] = ')';
            getParenth(n+1,arr,result,leftBraces,rightBraces-1);
        }
    }
	
	
	
	
	public ArrayList<String> getParenthesis(int count){
		ArrayList<String>  list = new ArrayList<String>();
		char str[] = new char[count * 2];
		addParen(list,str,count,count,0);
		return list;
	}
	
	public void addParen(ArrayList<String> list, char[] str, int leftparan, int rightparan , int count){
		if(leftparan <0 || rightparan<leftparan){
			return;
		}
		if(leftparan == 0 && rightparan == 0){
			String s = String.copyValueOf(str);
			list.add(s);
			
		}
		else{
			if(leftparan > 0){
				str[count] = '(';
				addParen(list,str,leftparan-1,rightparan,count+1);
			}
			if(rightparan > 0){
				str[count] = ')';
				addParen(list,str,leftparan,rightparan-1,count +1);
			}
		}
	}
}
