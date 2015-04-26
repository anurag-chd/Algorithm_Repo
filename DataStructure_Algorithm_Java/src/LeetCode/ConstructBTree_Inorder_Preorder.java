package LeetCode;

public class ConstructBTree_Inorder_Preorder {
	public static int preIndex= 0;
	public static void main(String args[]){
		int preorder[] = {1,2};
		int inorder[] = {2,1};
		
		TreeNode root = buildTree(preorder,inorder);
		printTree(root);
		
	}
	
	public static void printTree(TreeNode root){
		if(root == null)
			return;
		printTree(root.left);
		System.out.print(root.val+ " ,");
		printTree(root.right);
	}
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length != inorder.length)
            return null;
        TreeNode root = createTree(preorder,inorder,0,inorder.length-1);
        return root;
        
    }
    
    public static TreeNode createTree(int []preorder, int []inorder, int start, int end){
        if(start > end || preIndex>= preorder.length)
            return null;
        
        TreeNode root = new TreeNode(preorder[preIndex++]);
            
        int rootIndex = getIndex(inorder,root.val);
        root.left = createTree(preorder,inorder,start,rootIndex-1);
        root.right = createTree(preorder, inorder, rootIndex+1,end);
        
        return root;
    }
    
    public static int getIndex(int arr[], int val){
        for(int i =0; i< arr.length; i++){
            if(arr[i] == val)
                return i;
        }
        return -1;
    }
}
