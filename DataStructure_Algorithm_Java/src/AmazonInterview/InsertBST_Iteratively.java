package AmazonInterview;

import java.util.Queue;
import java.util.LinkedList;

public class InsertBST_Iteratively {
	public static void main(String args[]){
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(8);
		printTree(root);
		System.out.println();
		insertInTree(7,root);
		printTree(root);
	}
	
	public static void insertInTree(int num, TreeNode root){
		TreeNode newNode = new TreeNode(num);
		if(root == null){
			root = newNode;
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			if(temp.val > num){
				if(temp.left == null){
					temp.left = newNode;
					return;
				}
				else{
					queue.add(temp.left);
				}
			}
			else{
				if(temp.right == null){
					temp.right = newNode;
					return;
				}
				else{
					queue.add(temp.right);
				}
			}
		}
	}
	
	public static void printTree(TreeNode root){
		if(root == null)
			return;
		printTree(root.left);
		System.out.print(root.val+ ", ");
		printTree(root.right);
		
	}
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val){
		this.val = val;
	}
}
