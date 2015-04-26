package Vmware;

import java.awt.List;
import java.util.*;

import Basics.GenTreeNode;

public class BFS {
	static GenTreeNode root = new GenTreeNode('a');
	public static void main(String args[]){
		root.setLeft_child(new GenTreeNode('b'));
		root.setRight_child(new GenTreeNode('c'));
		root.getLeft_child().setLeft_child(new GenTreeNode('d'));
		root.getLeft_child().getLeft_child().setLeft_child(new GenTreeNode('e'));
		root.getRight_child().setLeft_child(new GenTreeNode('f'));
		
		traverse(root);
	}
	public static void traverse(GenTreeNode root){
		Queue<GenTreeNode> queue = new LinkedList<GenTreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			GenTreeNode temp = queue.remove();
			System.out.println(temp.getData());
			if(temp.getLeft_child()!= null){
				queue.add(temp.getLeft_child());
			}
			if(temp.getRight_child()!= null){
				queue.add(temp.getRight_child());
			}
		}
	}

}
