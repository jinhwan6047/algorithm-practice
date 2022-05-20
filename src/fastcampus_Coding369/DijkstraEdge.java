package fastcampus_Coding369;

public class DijkstraEdge implements Comparable<DijkstraEdge>{
	public int distance;
	public String vertex;
	
	public DijkstraEdge(int distance, String vertex) {
		this.distance = distance;
		this.vertex = vertex;
	}
	
	public String toString() {
		return "vertex : " + this.vertex + ", distance : " + this.distance;
	}
	
	@Override
	public int compareTo(DijkstraEdge edge) {
		// TODO Auto-generated method stub
		return this.distance -  edge.distance;
	}
	
}