package ProgrammeCreek.TreeHeap;

public class BinaryTree_Balanced {
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		// 2 layer
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
		// 3 layer
		root.left.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(4);
		root.right.left.left = new TreeNode(4);
		root.right.left.right = new TreeNode(4);
		root.right.right.left = new TreeNode(4);
		root.right.right.right = new TreeNode(4);
		
		//
		root.left.left.left.left = null;
		root.left.left.left.right = null;
		root.left.left.right.left = new TreeNode(5);
		root.left.left.right.right = new TreeNode(5);
		
		
		System.out.println(isBalancedTree(root));
	}
	
	public static boolean isBalancedTree(TreeNode root){
		if(root == null)
			return true;
		int max = getMaxHeight(root);
		int min = getMinHeight(root);
		return (max-min)>1?false:true;
	}
	
	public static int getMaxHeight(TreeNode root){
		if(root == null)
			return 0;
		return 1+ Math.max(getMaxHeight(root.left),getMaxHeight(root.right));
	}
	
	public static int getMinHeight(TreeNode root){
		if(root == null)
			return 0;
		return 1+ Math.min(getMinHeight(root.left),getMinHeight(root.right));
	}
}
