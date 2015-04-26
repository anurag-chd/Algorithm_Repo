package LeetCode;

import java.util.Stack;

public class IterativeInorderTraversal {
	public static void main(String args []){
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
		
		printInOrder(root);
	}
	
	public static void printInOrder(TreeNode root){
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		do{
			while(curr != null){
				stack.push(curr);
				curr = curr.left;
			}
			if(curr == null && !stack.isEmpty()){
				curr = stack.pop();
				System.out.print(curr.val+" ,");
				curr = curr.right;
			}
			
			
		}while(curr != null || !stack.isEmpty()); // important curr != null
		
		
	}
}
