package Vmware;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import Basics.BinaryST;
import Basics.TreeNode;

public class TreeLevelLinkedList {
	public static void main(String args[]){
		BinaryST btree = new BinaryST();
		btree.root = btree.insert(15, btree.root);
		btree.root = btree.insert(10, btree.root);
		btree.root = btree.insert(12, btree.root);
		btree.root = btree.insert(6, btree.root);
		btree.root = btree.insert(7, btree.root);
		btree.root = btree.insert(9, btree.root);
		btree.root = btree.insert(20,btree.root);
		btree.root = btree.insert(16, btree.root);
		btree.root = btree.insert(21, btree.root);
		btree.root = btree.insert(23, btree.root);
		btree.root = btree.insert(25, btree.root);
		btree.root = btree.insert(28, btree.root);
		btree.root = btree.insert(30, btree.root);
		
		ArrayList<java.util.LinkedList<TreeNode>> node_list = new ArrayList<java.util.LinkedList<TreeNode>>();
		node_list = getList(btree.root);
		Iterator i = node_list.iterator();
		while(i.hasNext()){
			LinkedList<TreeNode> list = (LinkedList<TreeNode>)i.next();
			Iterator i1 = list.iterator();
			while(i1.hasNext()){
				TreeNode t =(TreeNode)i1.next();
				System.out.print(t.getData()+" ");
			}
			System.out.println();
		}

	}
	
	public static ArrayList<java.util.LinkedList<TreeNode>> getList(TreeNode root){
		ArrayList<java.util.LinkedList<TreeNode>> result = new ArrayList<java.util.LinkedList<TreeNode>>();
		
		if(root == null){
			return null;
		}
		else{
			System.out.println("Hii");
			LinkedList<TreeNode> current = new LinkedList<TreeNode>();
			current.add(root);
			while(!current.isEmpty()){
				LinkedList<TreeNode> parents = new LinkedList<TreeNode>();
				parents = current;
				result.add(parents);
				current = new LinkedList<TreeNode>();
				for(TreeNode parent : parents){
					if(parent.getLeft_child()!=null)
						current.add(parent.getLeft_child());
					if(parent.getRight_child()!=null)
						current.add(parent.getRight_child());
				}
			}
			return result;
		}
		
	}
	
}
