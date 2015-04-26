package ProgrammeCreek.TreeHeap;

public class BuildBinaryTree_Postorder_Inorder {
	static int postIndex = -1;
	public static void main(String args[]){
		int inorder [] = {4,2,5,1,6,7,3,8};
		int postorder[] = {4,5,2,6,7,8,3,1};
		
		TreeNode root = buildTree(inorder,postorder);
		
		printTree(root);
		
	}
	
	public static TreeNode buildTree(int [] inorder, int [] postorder){
		if(inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length)
			return null;
		int inStart = 0;
		int inEnd = inorder.length-1;
		postIndex = postorder.length-1;
		
		return createTree(inorder,postorder,inStart,inEnd);
	}
	
	public static TreeNode createTree(int [] inorder, int[] postorder, int inStart, int inEnd){
		if(inStart > inEnd || postIndex <0){
			return null;
		}
		TreeNode root = new TreeNode(postorder[postIndex]);
		postIndex--;
		int rootIndex = -1;
		for(int i = inStart ; i<= inEnd ; i++){
			if(inorder[i] == root.val){
				rootIndex = i;
				break;
			}
		}
		
		root.right = createTree(inorder,postorder,rootIndex+1,inEnd);
		root.left = createTree(inorder,postorder,inStart, rootIndex-1);
		
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
