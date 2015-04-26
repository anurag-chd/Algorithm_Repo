package ProgrammeCreek.TreeHeap;

public class PathSum {
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
		
		System.out.println(hasPathSum(root,25));
	}
	
	public static boolean hasPathSum(TreeNode root, int sum){
		if(root == null)
			return false;
		sum = sum - root.val;
		if(root.left == null && root.right == null){
			if(sum == 0)
				return true;
			else
				return false;
		}
		return (hasPathSum(root.left,sum) || hasPathSum(root.right,sum));
	}
}
