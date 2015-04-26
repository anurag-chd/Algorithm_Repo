package ProgrammeCreek.TreeHeap;

public class FlattenBinaryTree {
	public static TreeNode parent = null;
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
		TreeNode left = root.left;
		TreeNode right = root.right;
		if(parent != null){
			parent.right = root;
		}
		parent = root;
		flatten(left);
		flatten(right);
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
