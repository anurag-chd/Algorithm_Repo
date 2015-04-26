package Commvault;

//package Commvault;

public class ChildTree {
	public static void main(String args[]){
		TreeNode2 root1 = new TreeNode2(1);
		root1.left = new TreeNode2(2);
		root1.right = new TreeNode2(3);
		root1.left.left = new TreeNode2(4);
		root1.left.left.left = new TreeNode2(5);
		root1.left.left.left.left = new TreeNode2(6);
		
		TreeNode2 root2 = new TreeNode2(4);
		root2.left = new TreeNode2(5);
		//root2.left.left = new TreeNode2(10);
		
		System.out.println(isChild(root1, root2));
	}
	
	public static boolean isChild(TreeNode2 root1, TreeNode2 root2){
		if(root1 == null)
			return false;
		else if(root2 == null)
			return true;
		
		TreeNode2 temp = getMatchingNode(root1,root2);
		return isMatching(temp,root2);
	}
	
	public static boolean isMatching(TreeNode2 root1, TreeNode2 root2){
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		if(root1.data != root2.data)
			return false;
		boolean left = isMatching(root1.left, root2.left);
		boolean right = isMatching(root1.right, root2.right);
		if(left && right)
			return true;
		else
			return false;
			
	}
	
	
	public static TreeNode2 getMatchingNode(TreeNode2 root1, TreeNode2 root2){
		if(root1 == null)
			return null;
		if(root1.data == root2.data)
			return root1;
		TreeNode2 left = getMatchingNode(root1.left,root2);
		TreeNode2 right = getMatchingNode(root1.right,root2);
		
		return left == null?right:left;
	}
}

class TreeNode2{
	int data;
	TreeNode2 left;
	TreeNode2 right;
	
	public TreeNode2(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
