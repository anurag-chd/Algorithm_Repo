package Geek4Geeks_Trees;

public class ConnectSameLevel_Recurrsive {
	public static void main(String args[]){
		TreeNode root = new TreeNode('a');
		root.lChild = new TreeNode('b');
		root.rChild = new TreeNode('c');
		root.lChild.lChild = new TreeNode('d');
		root.lChild.rChild = new TreeNode('e');
		root.rChild.lChild = new TreeNode('f');
		root.lChild.lChild.lChild = new TreeNode('g');
		
		connectLevel(root);
		
		ConnectSameLevel_Nodes.printLevelTree(root);
		
	}
	
	public static void connectLevel(TreeNode root){
		if(root == null)
			return;
		
		if(root.right !=null){
			connectLevel(root.right);
		}
		
		if(root.lChild != null){
			if(root.rChild != null){
				root.lChild.right = root.rChild;
				root.rChild.right = getNextRight(root);
			}
			else{
				root.lChild.right = getNextRight(root); 
			}
			connectLevel(root.lChild);	
		}
		else if(root.rChild != null){
			root.right = getNextRight(root);
			connectLevel(root.rChild);
		}
		else{
			connectLevel(getNextRight(root));
		}
	}
	
	public static TreeNode getNextRight(TreeNode root){
		TreeNode temp = root.right;
		while(temp !=null){
			if(temp.lChild!=null){
				return temp.lChild;
			}
			if(temp.rChild!=null){
				return temp.rChild;
			}
			temp = temp.right;
		}
		return null;
	}
}


