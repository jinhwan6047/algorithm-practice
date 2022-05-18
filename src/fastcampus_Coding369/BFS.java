package fastcampus_Coding369;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BFS {

	public void bfs(HashMap<String, ArrayList<String>> graph) {
		ArrayList<String> visited = new ArrayList<>();
		ArrayList<String> unvisit = new ArrayList<>();
		unvisit.add("A");
		
		while(unvisit.size()>0) {
			if(!visited.contains(unvisit.get(0))){
				unvisit.addAll(graph.get(unvisit.get(0)));
				visited.add(unvisit.get(0));
			}
			unvisit.remove(0);
		}
		
		System.out.println(visited);
	}
	public static void main(String[] args) {
		HashMap<String, ArrayList<String>> graph = new HashMap<>();
		
		graph.put("A",new ArrayList<String>(Arrays.asList("B","C")));
		graph.put("B",new ArrayList<String>(Arrays.asList("A","D")));
		graph.put("C",new ArrayList<String>(Arrays.asList("A","G","H","I")));
		graph.put("D",new ArrayList<String>(Arrays.asList("B","E","F")));
		graph.put("E",new ArrayList<String>(Arrays.asList("D")));
		graph.put("F",new ArrayList<String>(Arrays.asList("D")));
		graph.put("G",new ArrayList<String>(Arrays.asList("C")));
		graph.put("H",new ArrayList<String>(Arrays.asList("C")));
		graph.put("I",new ArrayList<String>(Arrays.asList("C", "J")));
		graph.put("J",new ArrayList<String>(Arrays.asList("I")));
		
		System.out.println(graph);
		BFS b = new BFS();
		b.bfs(graph);
	}

}
