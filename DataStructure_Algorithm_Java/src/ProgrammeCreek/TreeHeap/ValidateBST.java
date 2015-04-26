package ProgrammeCreek.TreeHeap;

public class ValidateBST {
	static TreeNode parent = null;
	public static void main(String args[]){
		TreeNode root = new TreeNode(20);
		//root.left = new TreeNode(10);
		root.right = new TreeNode(30);
		// left subtree
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(12);
		root.left.right.right = new TreeNode(15);
		root.left.right.right.right = new TreeNode(18);
		// right subtree
		root.right.left = new TreeNode(27);
		root.right.right = new TreeNode(2);
		root.right.right.right = new TreeNode(40);
		
		System.out.println(isValidBST(root));
		
	}
	
	public static boolean isValidBST(TreeNode root){
		if(root == null)
			return true;
		boolean left = isValidBST(root.left);
		if(parent != null){
			if(parent.val >= root.val)
				return false;
		}
		parent = root;
		boolean right = isValidBST(root.right);
		if(!left || !right){
			return false;
		}
		else
			return true;
	}

	
	

}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val){
		this.val = val;
	}
	
	public String toString(){
		return Integer.toString(this.val);
	}
}