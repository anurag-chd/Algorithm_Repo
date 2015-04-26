package ProgrammeCreek.TreeHeap;

public class SortedArry_BST {
	public static void main(String args[]){
		int arr[ ] = {1,12,13,23,34,45,100};
		TreeNode root = sortedArrayToBST(arr);
		printTree(root);	
		
	}
	
	public static TreeNode sortedArrayToBST(int num[]){
		if(num.length == 0)
			return null;
		int start = 0;
		int end = num.length-1;
		return createTree(num,start,end);
	}
	
	public static TreeNode createTree(int num[], int start, int end){
		if(start > end)
			return null;
		int mid = (start + end)/2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = createTree(num, start, mid-1);
		root.right = createTree(num, mid+1, end);
		
		return root;
	}
	
	public static void printTree(TreeNode root){
		if(root == null)
			return;
		printTree(root.left);
		System.out.print(root.val+" ,");
		printTree(root.right);
	}
}
