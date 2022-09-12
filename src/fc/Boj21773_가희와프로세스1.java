package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj21773_가희와프로세스1 {
	static StringBuilder sb = new StringBuilder();
	static int n,t;
	static PriorityQueue<Process> list = new PriorityQueue<>();
	
	public static class Process implements Comparable<Process>{
		int id;
		int time;
		int rank;
		public Process(int id, int time, int rank) {
			super();
			this.id = id;
			this.time = time;
			this.rank = rank;
		}
		@Override
		public int compareTo(Process o) {
			// TODO Auto-generated method stub
			if(this.rank == o.rank) return this.id-o.id;
			else return o.rank-this.rank;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n3 = Integer.parseInt(st.nextToken());
			
			list.add(new Process(n1,n2,n3));
		}
		
		schedule();
	}

	private static void schedule() {
		int cnt=0;
		while(cnt<t) {
			Process p = list.poll();
			sb.append(p.id).append("\n");
			p.time--;
			p.rank--;
			if(p.time != 0) {
				list.add(p);				
			}
			cnt++;
		}
		System.out.println(sb);
	}
}
