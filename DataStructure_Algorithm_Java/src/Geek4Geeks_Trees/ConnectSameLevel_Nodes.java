package Geek4Geeks_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectSameLevel_Nodes {
	public static void main(String args[]){
		TreeNode root = new TreeNode('a');
		root.lChild = new TreeNode('b');
		root.rChild = new TreeNode('c');
		root.lChild.lChild = new TreeNode('d');
		root.lChild.rChild = new TreeNode('e');
		root.rChild.lChild = new TreeNode('f');
		root.lChild.lChild.lChild = new TreeNode('g');
		
		connectLevel(root);
		
		printLevelTree(root);
		
	}
	
	public static void printLevelTree(TreeNode root){
		if(root == null)
			return;
		
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode temp = root;
		queue.add(temp);
		while(!queue.isEmpty()){
			temp = queue.poll();
			System.out.print(temp.data);
			if(queue.isEmpty() || temp.right != queue.peek() || temp.right == null)
				System.out.println("-->NULL");
			else{
				System.out.print("--> ");
			}
			
			if(temp.lChild != null){
				queue.add(temp.lChild);
			}
			if(temp.rChild != null){
				queue.add(temp.rChild);
			}
		}
	}
	
	public static void connectLevel(TreeNode root){
		if(root == null)
			return;
		int level =0;
		Queue<TreeLevel> queue = new LinkedList<>();
		TreeNode temp = root;
		queue.add(new TreeLevel(temp,level));
		TreeLevel n = null;
		while(!queue.isEmpty()){
			// deque the first element
			n = queue.poll();
			
			//check if the queue has more nodes so as to connect the same level nodes
			if(!queue.isEmpty() && n.level == queue.peek().level){
				n.node.right = queue.peek().node;
			}
			
			level = n.level+1;
			// add the children of node to the queue
			if(n.node.lChild != null)
				queue.add(new TreeLevel(n.node.lChild,level));
			if(n.node.rChild != null)
				queue.add(new TreeLevel(n.node.rChild,level));
		}
		return;
	}
}

class TreeNode{
	char data;
	TreeNode lChild;
	TreeNode rChild;
	TreeNode right;
	
	public TreeNode(char data){
		this.data = data;
	}
	
}

class TreeLevel{
	TreeNode node;
	int level;
	
	public TreeLevel(TreeNode node, int level){
		this.node = node;
		this.level = level;
	}
}