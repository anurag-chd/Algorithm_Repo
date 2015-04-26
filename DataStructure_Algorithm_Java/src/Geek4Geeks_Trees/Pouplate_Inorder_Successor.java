package Geek4Geeks_Trees;

public class Pouplate_Inorder_Successor {
	static TreeNodeNext parent = null;
	public static void main(String args[]){
		TreeNodeNext root = new TreeNodeNext('a');
		root.lChild = new TreeNodeNext('b');
		root.rChild = new TreeNodeNext('c');
		root.lChild.lChild = new TreeNodeNext('d');
		root.lChild.rChild = new TreeNodeNext('e');
		root.rChild.lChild = new TreeNodeNext('f');
		root.lChild.lChild.lChild = new TreeNodeNext('g');
		
		populateSuccessor(root);
		TreeNodeNext temp = root;
		while(temp.lChild!=null){
			temp = temp.lChild;
		}
		
		while(temp !=null){
			System.out.print(temp.data+" ,");
			temp = temp.next;
		}
		
		
	}
	
	public static void populateSuccessor(TreeNodeNext root){
		if(root == null)
			return;
		populateSuccessor(root.rChild);
		root.next = parent;
		parent = root;
		populateSuccessor(root.lChild);
	}
	
	
	
}

class TreeNodeNext{
	char data;
	TreeNodeNext lChild;
	TreeNodeNext rChild;
	TreeNodeNext next;
	
	public TreeNodeNext(char data){
		this.data = data;
	}
	
}