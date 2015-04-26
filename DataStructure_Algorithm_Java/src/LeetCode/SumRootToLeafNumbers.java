package LeetCode;

import java.util.ArrayList;

public class SumRootToLeafNumbers {
	public static int sum = 0;
	public static void main(String args[]){
		TreeNode root = new TreeNode(0);
		// left subtree
		root.left = new TreeNode(1);
		/*root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		// right subtree
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(6);
		*/
		
		
		
		System.out.println(sumNumbers(root));
	}
	
	public static int sumNumbers(TreeNode root){
		if(root == null)
			return sum;
		int num = 0;
		addNumbers(root,num);
		int res = sum;
		sum =0;
		return res;
	}
	
	public static void addNumbers(TreeNode root, int num ){
		if(root == null){
			return;
		}
		if(root.left == null && root.right == null){
			num = root.val + (num * 10);
			sum = sum + num;
			return;
		}
		
		num = root.val + (num * 10);
		addNumbers(root.left,num);
		addNumbers(root.right,num);
	}
}
