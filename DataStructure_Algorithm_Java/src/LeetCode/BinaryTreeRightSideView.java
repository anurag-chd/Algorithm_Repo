package LeetCode;

import java.util.LinkedList;
import java.util.Queue;



public class BinaryTreeRightSideView {
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		// left subtree
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.left.right = new TreeNode(9);
		
		// right subtree
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right  = new TreeNode(6);
		root.right.left.right = new TreeNode(8);
		
		printRightSide(root);
		
	}
	
	public static void printRightSide(TreeNode root){
		if(root == null)
			return;
		Queue<TreeNode> current = new LinkedList<>();
		Queue<TreeNode> next = new LinkedList<>();
		
		current.add(root);
	
		while(!current.isEmpty()){
			TreeNode temp = current.poll();
			if(temp.left != null){
				next.add(temp.left);
			}
			if(temp.right != null)
				next.add(temp.right);
			
			if(current.isEmpty()){
				System.out.println(temp.val);
				Queue<TreeNode> swap = current;
				current = next;
				next = swap;
			}
		}
		
	}
	
}
