package fastcampus_Coding369;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkstraPath {
	public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<DijkstraEdge>> graph, String start){
		DijkstraEdge edgeNode, adjacentNode;
		ArrayList<DijkstraEdge> nodeList;
		int currentDistance, weight, distance;
		String currentNode, adjacent;
		HashMap<String, Integer> distances = new HashMap<>();
		for(String key : graph.keySet()) {
			distances.put(key, Integer.MAX_VALUE);
		}
		distances.put(start, 0);
		
		PriorityQueue<DijkstraEdge> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new DijkstraEdge(distances.get(start), start));
		
		while(priorityQueue.size()>0) {
			edgeNode = priorityQueue.poll();
			currentDistance = edgeNode.distance;
			currentNode = edgeNode.vertex;
			
			if(distances.get(currentNode) < currentDistance) {
				continue;
			}
			nodeList = graph.get(currentNode);
			for(int i=0; i<nodeList.size(); i++) {
				adjacentNode = nodeList.get(i);
				adjacent = adjacentNode.vertex;
				weight = adjacentNode.distance;
				distance = currentDistance + weight;
				
				if(distance<distances.get(adjacent)) {
					distances.put(adjacent, distance);
					priorityQueue.add(new DijkstraEdge(distance, adjacent));
				}
			}
		}
		
		return distances;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DijkstraPath dp = new DijkstraPath();
		HashMap<String, ArrayList<DijkstraEdge>> graph = new HashMap<>();
		graph.put("A", new ArrayList<DijkstraEdge>(Arrays.asList(new DijkstraEdge(8,"B"), new DijkstraEdge(1,"C"), new DijkstraEdge(2,"D"))));
		graph.put("B", new ArrayList<DijkstraEdge>());
		graph.put("C", new ArrayList<DijkstraEdge>(Arrays.asList(new DijkstraEdge(5,"B"), new DijkstraEdge(2,"D"))));
		graph.put("D", new ArrayList<DijkstraEdge>(Arrays.asList(new DijkstraEdge(3,"E"), new DijkstraEdge(5,"F"))));
		graph.put("E", new ArrayList<DijkstraEdge>(Arrays.asList(new DijkstraEdge(1,"F"))));
		graph.put("F", new ArrayList<DijkstraEdge>(Arrays.asList(new DijkstraEdge(5,"A"))));
		
		System.out.println(dp.dijkstraFunc(graph, "A"));
	}

}



