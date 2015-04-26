package LeetCode;

public class RecoverBinaryTree {
	public static TreeNode prev = null, node1 = null, node2 = null;
	public static void main(String args[]){
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.right = new TreeNode(8);
		root.left.right.left = new TreeNode(6);
		root.left.right.right = new TreeNode(12);
		
		root.right = new TreeNode(13);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(15);
		root.right.right.right = new TreeNode(17);
		
		recoverTree(root);
		
		printTree(root);
		
	}
	public static void recoverTree(TreeNode root){
		if(root == null)
			return;
		TreeNode curr = root;
		inorderTraversal(curr);
		int temp = node1.val;
		node1.val = node2.val;
		node2.val = temp;
		return;
	}
	
	public static void inorderTraversal(TreeNode curr){
		if(curr == null)
			return;
		inorderTraversal(curr.left);
		if(prev != null){
			if(curr.val <= prev.val){
				if(node1 == null)
					node1 = prev;
				else
					node2 = curr;
			}
		}
		prev = curr;
		inorderTraversal(curr.right);
	}
	
	public static void printTree(TreeNode root){
		if(root == null)
			return;
		printTree(root.left);
		System.out.print(root.val+" ,");
		printTree(root.right);
	}
}
