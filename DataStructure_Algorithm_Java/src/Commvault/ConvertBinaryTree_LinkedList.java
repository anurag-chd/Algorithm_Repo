package Commvault;

public class ConvertBinaryTree_LinkedList {
	public static Treenode parent = null;
	public static void main(String args[]){
		Treenode root = new Treenode(20);
		root.left = new Treenode(10);
		root.right = new Treenode(30);
		
		root.left.left = new Treenode(5);
		root.left.left.left = new Treenode(2);
		root.left.right = new Treenode(15);
		
		root.right.left = new Treenode(25);
		root.right.left.left = new Treenode(22);
		root.right.right = new Treenode(35);
		
		createList(root);
		Treenode head = null;
		while(root.left != null)
			root = root.left;
		
		head = root;
		displayList(head);
		
	}
	
	public static void displayList(Treenode head){
		if(head == null)
			return;
		Treenode temp = head;
		while(temp.right !=null){
			System.out.print(temp.data +" ,");
			temp = temp.right;
		}
	}
	
	public static void createList(Treenode root){
		if(root == null)
			return ;
		createList(root.left);
		if(parent == null){
			parent = root;
			return ;
		}
		else{
			parent.right = root;
			root.left = parent;
			parent = root;
			
		}
		createList(root.right);
		
		
	}

}

class Treenode{
	int data;
	Treenode left;
	Treenode right;
	
	public Treenode(int data){
		this.data = data;
	}
	
	public String toString(){
		return String.valueOf(this.data);
	}
}
