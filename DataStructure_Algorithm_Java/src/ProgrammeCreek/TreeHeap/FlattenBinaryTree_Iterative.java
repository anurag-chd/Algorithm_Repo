package ProgrammeCreek.TreeHeap;

import java.util.Stack;

public class FlattenBinaryTree_Iterative {
	public static void main(String args[]){
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);
		// left subtree
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(12);
		root.left.right.right = new TreeNode(15);
		root.left.right.right.right = new TreeNode(18);
		// right subtree
		root.right.left = new TreeNode(27);
		root.right.right = new TreeNode(35);
		root.right.right.right = new TreeNode(40);
		flatten(root);
		printTreeList(root);
	}
	
	public static void flatten(TreeNode root){
		if(root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while(node != null || !stack.isEmpty()){
			if(node.right != null){
				stack.push(node.right);
			}
			if(node.left != null){
				node.right = node.left;
				node.left = null;
			}
			else if(!stack.isEmpty()){
				node.right = stack.pop();
			}
			node = node.right;
			
		}
	}
	
	public static void printTreeList(TreeNode root){
		if(root == null) {
			return;
		}
		TreeNode temp = root;
		while(temp != null){
			System.out.print(temp.val+"->");
			temp = temp.right;
		}
		System.out.println();
			
	}
}
