package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1967_트리의지름 {
	static StringBuilder sb = new StringBuilder();
	static int v;
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
		v = Integer.parseInt(br.readLine());
		
		conn = new ArrayList[v+1];
		for(int i=0; i<v+1; i++) {
			conn[i] = new ArrayList<>();
		}
		
		StringTokenizer st;
		for(int i=0; i<v; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int num = Integer.parseInt(st.nextToken());
			int temp = Integer.parseInt(st.nextToken());
			while(temp != -1) {
				conn[num].add(new node(temp, Integer.parseInt(st.nextToken())));
				temp = Integer.parseInt(st.nextToken());
			}
		}
		
		visit = new boolean[v+1];
		visit[0] = true;
		visit[1] = true;
		searchDis(1, 0);
		
		visit = new boolean[v+1];
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
