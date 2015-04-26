package Geek4Geeks_Trees;

import Basics.GenTreeNode;

public class InorderSuccessorBST {
	public static void main(String args[]){
		GenTreeNode<Integer> root = new GenTreeNode<Integer>(10);
		root.setLeft_child(new GenTreeNode(6));
		root.setRight_child(new GenTreeNode(12));
		root.getLeft_child().setLeft_child(new GenTreeNode(4));
		root.getLeft_child().setRight_child(new GenTreeNode(8));
		root.getRight_child().setRight_child(new GenTreeNode(14));
		root.getLeft_child().getRight_child().setLeft_child(new GenTreeNode(7));
		root.getLeft_child().getRight_child().setRight_child(new GenTreeNode(9));
		
		GenTreeNode<Integer> succ = getSuccessor(root ,root.getLeft_child().getRight_child().getRight_child());
		System.out.println(succ.getData());
	}
	
	public static GenTreeNode<Integer> getSuccessor(GenTreeNode<Integer> root,GenTreeNode node){
		if(node == null || root == null)
			return null;
		GenTreeNode suc;
		if(node.getRight_child() != null){
			suc = getLeftMost(node.getRight_child());
			return suc;
		}
		else{
			suc = searchSuccessor(root,node);
			return suc;
		}
		
	}
	
	public static GenTreeNode<Integer> searchSuccessor(GenTreeNode<Integer> root, GenTreeNode<Integer> node){
		GenTreeNode<Integer> temp = null;
		
		while(root != null){
			if(node.getData() > root.getData()){
				root = root.getRight_child();
			}
			else if(node.getData() < root.getData()){
				temp = root;
				root = root.getLeft_child();
			}
			else{
				break;
			}
			
		}
		return temp;
		
			
		
	}
	
	public static GenTreeNode<Integer> getLeftMost(GenTreeNode<Integer> root){
		GenTreeNode<Integer> temp = root;
		while(temp.getLeft_child()!=null)
			temp = temp.getLeft_child();
		return temp;
	}

}
