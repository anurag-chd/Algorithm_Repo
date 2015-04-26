package ProgrammeCreek.TreeHeap;

public class MinDepth_BinaryTree {
	public static boolean flag = false; 
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
		
		System.out.println(minDepth(root));
	}
	
	public static int minDepth(TreeNode root){
		if(root == null)
            return 0;
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        if(left==0)
            return right+1;
        if(right==0)
            return left+1;
        return left<right ? left+1:right+1;

		
	}
	
	
}
