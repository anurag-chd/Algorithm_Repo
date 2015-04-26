package LeetCode;

import java.util.Stack;

public class SimplifiedPath {
	public static void main(String args[]){
		String str = "/.";
		System.out.println(simplifyPath(str));
	}
	
	public static String simplifyPath(String path){
		if(path == null || path.length() ==0)
			return path;
		StringBuilder sbr = new StringBuilder();
		Stack<String> stack = new Stack<>();
		String strArr[] = path.split("/");
		for(String s: strArr){
			if(s.length() == 0 || s.equals(".")){
				
			}
			else if(s.equals("..")){
				if(!stack.isEmpty())
					stack.pop();
			}
			else{
				stack.push(s);
			}
		}
		if(stack.isEmpty())
			sbr.append("/");
		else{
			while(!stack.isEmpty()){
				sbr.insert(0,stack.pop());
				sbr.insert(0, "/");
			}
		}
		
		return sbr.toString();
		
	}	
}
