package Vmware;

import java.util.ArrayList;
import java.util.Stack;

public class GraphReversal {

	public static void main(String args[]){
		// create node of graph
		Node a = new Node('A');
		Node b = new Node('B');
		Node c = new Node('C');
		Node d = new Node('D');
		
		// create the edges
		a.friends.add(b);
		b.friends.add(c);
		c.friends.add(b);
		d.friends.add(c);
		
		// Function to print in dfs
		printDfs(a);	
		
		// function to reverse the edges
		reverseEdge(a);
		printDfs(b);
		
	}
	
	public static void printDfs(Node a){
		Stack<Node> s= new Stack<Node>();
		boolean visited[] = new boolean [256];
		for(int i =0 ; i<256 ;i++){
			visited[i] = false;
		}
		s.push(a);
		while(!s.isEmpty()){
			Node temp = s.pop();
			System.out.print(temp.name+"-> ");
			for(Node n : temp.friends){
				if(!visited[n.name]){
					s.push(n);
				}
			}
			visited[temp.name] = true;
		}
		System.out.println();
	}

	public static void reverseEdge(Node a){
	
		Node temp = a;
		Stack<Node> s= new Stack<Node>();
		boolean visited[] = new boolean [256];
		for(int i =0 ; i<256 ;i++){
			visited[i] = false;
		}
			
		s.push(temp);
		while(!s.isEmpty()){
			temp = s.pop();
			int i = 0;
			
			while(i<temp.friends.size()){
				Node temp2 = temp.friends.get(i);
				if(!visited[temp2.name]){
					s.push(temp2);
					if(!temp2.friends.contains(temp)){
						temp2.friends.add(temp);
						temp.friends.remove(temp2);
					}
					else{
						i++;
					}
				}
				else{
					i++;
				}
			}
					
			visited[temp.name] = true;
			
		}
	
	}

}




class Node{
	
	public char name;
	public ArrayList<Node> friends;
	
	public Node(char name){
		this.name = name;
		friends = new ArrayList<Node>();
	}
	public char getName() {
		return name;
	}
	public void setName(char name) {
		this.name = name;
	}
	public ArrayList<Node> getFriends() {
		return friends;
	}
	public void setFriends(ArrayList<Node> friends) {
		this.friends = friends;
	}
}