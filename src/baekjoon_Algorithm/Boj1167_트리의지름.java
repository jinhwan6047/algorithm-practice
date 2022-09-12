package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1167_트리의지름 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static ArrayList<node>[] conn;
	static boolean[] visit;
	static int maxDis, idx;

	public static class node{
		int x;
		int distance;
		public node(int x, int distance) {
			super();
			this.x = x;
			this.distance = distance;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		conn = new ArrayList[n+1];
		for(int i=0; i<n+1; i++) {
			conn[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for(int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int num3 = Integer.parseInt(st.nextToken());
			conn[num1].add(new node(num2, num3));
			conn[num2].add(new node(num1, num3));
			
		}
		
		visit = new boolean[n+1];
		visit[0] = true;
		visit[1] = true;
		searchDis(1, 0);
		
		visit = new boolean[n+1];
		visit[0] = true;
		visit[idx] = true;
		searchDis(idx, 0);
		
		System.out.println(maxDis);
	}
	public static void searchDis(int num, int cntDis) {
		if(cntDis>maxDis) {
			maxDis = cntDis;
			idx = num;
		}
		
		ArrayList<node> list = conn[num];
		
		for(int i=0; i<list.size(); i++) {
			node temp = list.get(i);
			
			if(!visit[temp.x]) {
				visit[temp.x] = true;
				searchDis(temp.x, cntDis+temp.distance);
			}
		}
	}
}
