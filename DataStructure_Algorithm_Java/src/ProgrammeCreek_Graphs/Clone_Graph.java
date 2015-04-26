package ProgrammeCreek_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Clone_Graph {
	public static void main(String args[]){
		UndirectedGraphNode node0 = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		node0.neighbours.add(node1);
		node0.neighbours.add(node2);
		node1.neighbours.add(node2);
		node2.neighbours.add(node2);
		
		UndirectedGraphNode copy = cloneGraph(node0);
		
		
		
	}
	
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
		if(node == null)
			return null;
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		
		queue.add(node);
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		map.put(node,newNode);
		while(!queue.isEmpty()){
			UndirectedGraphNode curr = queue.poll();
			List<UndirectedGraphNode> allNeighbours = curr.neighbours;
			for(UndirectedGraphNode neighbour: allNeighbours){
				if(!map.containsKey(neighbour)){
					UndirectedGraphNode temp = new UndirectedGraphNode(neighbour.label);
					map.put(neighbour, temp);
					map.get(curr).neighbours.add(temp);
					queue.add(neighbour);
				}
				else{
					map.get(curr).neighbours.add(map.get(neighbour));
				}
			}
		}
		return newNode;
		
		
	}

}

class UndirectedGraphNode{
	int label;
	List<UndirectedGraphNode> neighbours;
	
	public UndirectedGraphNode(int x){
		this.label = x;
		neighbours = new ArrayList<>();
	}
	
	
}
