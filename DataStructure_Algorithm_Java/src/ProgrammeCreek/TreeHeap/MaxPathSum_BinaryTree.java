package ProgrammeCreek.TreeHeap;

public class MaxPathSum_BinaryTree {
	static int max =0;
	public static void main(String args[]){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		// left subtree
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		
		// right subtree
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		
		System.out.println(maxPathSum(root));
	}
	
	public static int maxPathSum(TreeNode root){
		max = (root == null)?0:root.val;
		
		// traverse the tree is post order and calculate the sum
		calMaxPath(root);
		return max;
	}
	
	public static int calMaxPath(TreeNode root){
		if(root == null)
			return 0;
		int left = calMaxPath(root.left);
		int right = calMaxPath(root.right);
		
		max = Math.max(root.val + left+ right,max);
		
		return root.val + Math.max(left,right);
	}
}
