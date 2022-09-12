package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Boj22865_가장먼곳 {
	static StringBuilder sb = new StringBuilder();
	static int n,m;
	static ArrayList<Integer> friend = new ArrayList<Integer>();
	static ArrayList<Node>[] node;
	static int[] result;
	
		
	public static class Node implements Comparable<Node>{
		int no;
		int dist;
		public Node(int no, int dist) {
			super();
			this.no = no;
			this.dist = dist;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.dist-o.dist;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		node = new ArrayList[n+1];
		result = new int[n+1];
		for(int i=0; i<n+1; i++) {
			node[i] = new ArrayList<>();
			result[i] = Integer.MAX_VALUE;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		while(st.hasMoreTokens()) friend.add(Integer.parseInt(st.nextToken()));
		
		m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n3 = Integer.parseInt(st.nextToken());
			
			node[n1].add(new Node(n2, n3));
			node[n2].add(new Node(n1, n3));
		}
		
		for(int i=0; i<3; i++) {			
			chk(friend.get(i));	
		}
		
		int obNo=0;
		int obDist=0;
		for(int i=1; i<n+1; i++) {
			if(result[i]>obDist) {
				obNo = i;
				obDist = result[i];
			}
		}
		
		System.out.println(obNo);
	}

	private static void chk(int num) {
		int[] distance = new int[n+1];
		for(int i=1; i<n+1; i++) {
			if(i==num) continue;
			distance[i] = Integer.MAX_VALUE;
		}
		
		Queue<Node> list = new PriorityQueue<>();
		list.add(new Node(num, 0));
		
		while(!list.isEmpty()) {
			Node n = list.poll();
			
			ArrayList<Node> nodeList = node[n.no];
			for(int i=0; i<nodeList.size(); i++) {
				int nn = nodeList.get(i).no;
				int nd = nodeList.get(i).dist;
				
				if(n.dist+nd<distance[nn]) {
					distance[nn] = n.dist+nd;
					list.add(new Node(nn, n.dist+nd));					
				}
			}
						
		}
		for(int i=1; i<n+1; i++) {
			result[i] = Math.min(result[i], distance[i]); 
		}
	}
}
