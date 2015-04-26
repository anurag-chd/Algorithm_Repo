package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrderTraversal {
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		// left subtree
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(6);
		root.left.right.right = new TreeNode(7);
		
		// right subtree
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(9);
		root.right.left.right = new TreeNode(10);
		
		System.out.println(printPostOrder(root));
	}
	
	public static List<Integer> printPostOrder(TreeNode root){
		List<Integer> result = new ArrayList<>();
		if(root == null)
			return result;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		do{
			while(curr != null){
				if(curr.right!= null){
					stack.push(curr.right);
				}
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			if(!stack.isEmpty() && curr != null && curr.right == stack.peek()){
				TreeNode temp = stack.pop();
				stack.push(curr);
				curr = temp;
			}
			else{
				//System.out.print(curr.val+" ,");
				result.add(curr.val);
				curr = null;
			}
		}while(!stack.isEmpty());
		
		return result;
	}
}
