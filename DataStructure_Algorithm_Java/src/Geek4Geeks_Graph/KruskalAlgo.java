package Geek4Geeks_Graph;

import java.util.ArrayList;

public class KruskalAlgo {
	public static void main(String args[]){
		Graph_Weight graph = new Graph_Weight(4);
		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 2, 6);
		graph.addEdge(0, 3, 5);
		graph.addEdge(2, 3, 4);
		graph.addEdge(3, 1, 15);
		
		FindMst(graph);
	}
	
	public static void FindMst(Graph_Weight graph){
		
		sortEdge(graph.edges);
	}
	
	public static void sortEdge(ArrayList<Edges> edges){
		int edge_weight[] = new int[edges.size()];
		int edge_index[] = new int[edges.size()];
		
		for(int i =0 ; i< edge_weight.length; i++){
			edge_weight[i] = edges.get(i).getW();
			edge_index[i] = i;
		}
		
		sort(edge_weight,0, edge_weight.length-1,edge_index);
		ArrayList<Edges> temp_edges = new ArrayList<Edges>();	
		for(int i = 0; i< edges.size();i++){
			temp_edges.add(edges.get(edge_index[i]));
		}
		edges = temp_edges;
		Graph1 g = new Graph1(4);
		for(Edges e : edges){
			g.addEdge(e.src,e.des);
			if(UnionFind.isCycle(g)){
				g.removeEdge(e.src, e.des);
			}
		}
		for(Edge1 e1 :g.E1 ){
			System.out.println("("+e1.src+","+e1.des+")");
		}
		
	}
	
	public static void sort(int arr[], int start, int end, int index[]){
		if(start > end){
			return;
		}
		else{
			int pivot = arr[start];
			int left = start;
			int right = end;
			
			while(right>left){
				while(left<=end && arr[left]<= pivot)
					left++;
				while(right>=start && arr[right]> pivot)
					right--;
				if(right>=left){
					swap(arr,left,right,index);
				}
			}
			swap(arr,start,right,index);
			sort(arr,start,right-1,index);
			sort(arr,right+1,end,index);
		}
	
	}
	
	public static void swap(int [] arr, int left, int right, int index[]){
		int temp1, temp2;
		temp1 = arr[left];
		arr[left]= arr[right];
		arr[right] = temp1;
		
		temp2 = index[left];
		index[left]= index[right];
		index[right] = temp2;
	}

}


class Graph_Weight{
	int V;
	int E;
	ArrayList<Edges> edges;
	
	public Graph_Weight(int v){
		V = v;
		E = 0;
		edges = new ArrayList<Edges>();
	}
	
	public void addEdge(int src, int des, int w){
		Edges e = new Edges(src, des, w);
		edges.add(e);
		E++;
	}
}

class Edges{
	int src;
	int des;
	int w;
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
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	
	public Edges(int src, int des, int weight){
		this.src= src;
		this.des = des;
		this.w = weight;
	}
}