package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class IterativePostOrder {
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		System.out.println(postorderTraversal(root));
	}
	
	public static List<Integer> postorderTraversal(TreeNode root){
		List<Integer> result = new ArrayList<>();
		if(root == null)
			return result;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		result.add(root.val);
		TreeNode curr = null,prev = null;
		while(!stack.isEmpty()){
			curr = stack.peek();
			
			if(prev == null || prev.left == curr || prev.right == curr){
				if(curr.left != null){
					stack.push(curr.left);
					result.add(curr.left.val);
				}
					
				else if(curr.right != null){
					stack.push(curr.right);
					result.add(curr.right.val);
				}
					
				else{
					//result.add(stack.pop().val);
					stack.pop();
				}
			}
			else if(curr.left == prev){
				if(curr.right != null){
					stack.push(curr.right);
					result.add(curr.right.val);
				}
					
				else
					//result.add(stack.pop().val);
					stack.pop();
			}
			else if(curr.right == prev){
				//result.add(stack.pop().val);
				stack.pop();
			}
			prev = curr;
		}
		
		return result;
		
		
		
		
		
		
			
		
	}
	
}
