package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BuildExpressionTreeFromInfix {
	public static void main(String args[]){
		String str = "A+B*(C-D)";
		String postFix = getPostFix(str);
		System.out.println(postFix);
		ExpTreeNode root = getExpTree(postFix);
		printTree(root);
	}
	
	public static void printTree(ExpTreeNode root){
		if(root == null)
			return;
		printTree(root.left);
		System.out.print(root.exp);
		printTree(root.right);
	}
	
	public static ExpTreeNode getExpTree(String post){
		if(post == null || post.length() == 0)
			return null;
		Stack<ExpTreeNode> stack = new Stack<>();
		ExpTreeNode node = null;
		for(int i = 0; i < post.length() ;i++){
			String temp = post.substring(i,i+1);
			if(temp.matches("[A-Z]")){
				 node = new ExpTreeNode(temp);
				stack.push(node);
			}
			else{
				node = new ExpTreeNode(temp);
				node.right = stack.pop();
				node.left = stack.pop();
				stack.push(node);
			}
		}
		node = stack.pop();
		return node;
	
		
	}
	
	
	public static String getPostFix(String str){
		if(str == null || str.length()<3)
			return str;
		Map<String,Integer> precedenceMap = new HashMap<>();  
		//precedenceMap.put("(",3);
		precedenceMap.put("*",2);
		precedenceMap.put("/",2);
		precedenceMap.put("+",1);
		precedenceMap.put("-",1);
		
		Stack<String> stack = new Stack<>();
		StringBuilder sbr = new StringBuilder();
		for(int i = 0; i< str.length() ;i++){
			String temp = str.substring(i,i+1);
			if(temp.matches("[A-Z]") ){
				sbr.append(temp);
			}
			else{
				if(stack.isEmpty() || temp.equals("("))
					stack.push(temp);
				else{
					if(!temp.equals(")")){
						if(!stack.peek().equals("(")){
							while(!stack.isEmpty() && precedenceMap.get(stack.peek())>= precedenceMap.get(temp) ){
								sbr.append(stack.pop());
							}
						}
						
						stack.push(temp);
					}
					else{
						while(!stack.peek().equals("("))
							sbr.append(stack.pop());
						stack.pop();
					}
				}
			}
		}
		
		while(!stack.isEmpty())
			sbr.append(stack.pop());
		
		return sbr.toString();
	}
}


class ExpTreeNode{
	String exp;
	ExpTreeNode left;
	ExpTreeNode right;
	
	public ExpTreeNode(String str){
		this.exp = str;
	}
		
}