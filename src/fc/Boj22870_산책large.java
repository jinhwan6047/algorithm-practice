package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj22870_산책large {
	static StringBuilder sb = new StringBuilder();
	static int n,m,s,e;
	static ArrayList<Path>[] root;
	static boolean[] visit;
	static int[] history;
	static int cnt=0;
	
	public static class Path implements Comparable<Path>{
		int no;
		int dist;
		int weight;
		
		public Path(int no, int dist) {
			super();
			this.no = no;
			this.dist = dist;
		}
		
		public Path(int no, int dist, int weight) {
			super();
			this.no = no;
			this.dist = dist;
			this.weight = weight;
		}

		@Override
		public int compareTo(Path o) {
			// TODO Auto-generated method stub
			return this.dist-o.dist;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		root = new ArrayList[n+1];
		for(int i=0; i<n+1; i++) {
			root[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n3 = Integer.parseInt(st.nextToken());
			
			root[n1].add(new Path(n2, n3));
			root[n2].add(new Path(n1, n3));
		}
		
		for(int i=0; i<n+1; i++) {
			Collections.sort(root[i]);
		}
		
		st = new StringTokenizer(br.readLine()," ");
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n+1];
		history = new int[n+1];
		
		search(s, e);
		visit = new boolean[n+1];
		int chk = e;
		while(history[chk] != s) {
			chk = history[chk];
			visit[chk] = true;
		}
		search(e, s);
				
		System.out.println(cnt);
	}

	private static void search(int start, int end) {
		PriorityQueue<Path> list = new PriorityQueue<>();
		list.add(new Path(start, 0, 0));
		while(!list.isEmpty()) {
			Path p = list.poll();
			ArrayList<Path> temp = root[p.no]; 
			for(int i=0; i<temp.size(); i++) {
				Path tempP = temp.get(i);
				if(!visit[tempP.no]) {
					System.out.println(p.no+" : "+tempP.no+" : "+p.weight);
					visit[tempP.no] = true;
					history[tempP.no] = p.no;
					if(tempP.no == end) {
						cnt += p.weight;
						return;
					}
					list.add(new Path(tempP.no, tempP.dist, p.weight+tempP.dist));
				}
			}
		}
		
	}
}
