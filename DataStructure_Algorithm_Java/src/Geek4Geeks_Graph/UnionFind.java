package Geek4Geeks_Graph;

import java.util.ArrayList;

public class UnionFind {
	public static void main(String args[]){
		Graph1 g = new Graph1(3);
		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(0,2);
		
		if(isCycle(g))
			System.out.println("The graph has cycle");
		else
			System.out.println("The graph has no cycle");
		
	}
	
	public static boolean isCycle(Graph1 g){
		int parent[] = new int [g.V];
		int vertex = g.V;
		for(int i =0 ; i< vertex ; i++){
			parent[i] = -1;
		}
		
		for(Edge1 e: g.E1){
			int src = e.src;
			int des = e.des;
			int src_p = findParent(src,parent);
			int des_p = findParent(des,parent);
			if(src_p == des_p){
				return true;
			}
			else{
				union(src,des,parent);
			}
			
		}
		return false;
	}
	
	public static void union(int src, int des, int [] parent){
		int src_p = findParent(src,parent);
		int des_p = findParent(des,parent);
		parent[src_p] = des_p;
				
	}
	
	public static int findParent(int src, int [] parent){
		if(parent[src] == -1)
			return src;
		else{
			return findParent(parent[src],parent);
			
		}
	}
}

class Graph1{
	int V;
	ArrayList <Edge1> E1;
	
	public int getV() {
		return V;
	}

	public void setV(int v) {
		V = v;
	}

	public ArrayList<Edge1> getE1() {
		return E1;
	}

	public void setE(ArrayList<Edge1> e) {
		E1 = e;
	}

	public Graph1(int vertex){
		V = vertex;
		E1 = new ArrayList<Edge1>();
	}
	
	public void addEdge(int src, int des){
		Edge1 e = new Edge1(src,des);
		E1.add(e);
	}
	
	public void removeEdge(int src, int des){
		for(Edge1 e : E1){
			if(e.src == src && e.des == des){
				E1.remove(e);
				break;
			}
				
		}
	}
}

class Edge1{
	int src;
	int des;
	public int getSrc() {
		return src;
	}
	public void setSrc(int src) {
		this.src = src;
	}
	public int getDes() {
		return des;
	}
	public void setDes(int des) {
		this.des = des;
	}
	
	public Edge1(int src, int des){
		this.src = src;
		this.des = des;
	}
}
