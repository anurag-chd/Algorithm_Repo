package ProgrammeCreek.String_Array_Matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	public static void main(String args[]){
		String str = "(((({}})))";
		System.out.println(isValid(str));
	}
	public static boolean isValid(String s){
		if(s == null || s.length() == 0)
			return true;
		Map<Character, Character> parMap = new HashMap<>();
		parMap.put('{','}');
		parMap.put('(', ')');
		parMap.put('[',']' );
		
		Stack<Character> stack = new Stack<>();
		for(int index = 0 ; index < s.length(); index++){
			switch (s.charAt(index)){
				case '{':
				case '(':
				case '[':
					stack.push(s.charAt(index));
					break;
				case '}':
				case ')':
				case ']':
					if(stack.isEmpty())
						return false;
					else{
						char c = stack.pop();
						if(s.charAt(index) != parMap.get(c))
							return false;
						else
							break;
					}
					
			}
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
		
	}
}
