package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj1260_DFS와BFS {
	static StringBuilder sb = new StringBuilder();
	static int n, m, v;
	static boolean[] visit;

	static ArrayList<Integer> searchList = new ArrayList<Integer>();
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n];
		for(int i=0; i<n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num1 = Integer.parseInt(st.nextToken())-1;
			int num2 = Integer.parseInt(st.nextToken())-1;
			
			list[num1].add(num2);
			list[num2].add(num1);
		}
		
		for(int i=0; i<n; i++) {
			Collections.sort(list[i]);
			//System.out.println(list[i].toString());
		}
		
		visit = new boolean[n];
		dfs(v-1);
		sb.append("\n");
		
		visit = new boolean[n];
		bfs(v-1);
		
		System.out.println(sb);
	}

	static void bfs(int idx) {
		visit[idx] = true;
		sb.append((idx+1)+" ");
		
		ArrayList<Integer> checkList = new ArrayList<Integer>();
		checkList.add(idx);
		while(!checkList.isEmpty()) {
			int temp = checkList.remove(0);
			for(int i=0; i<list[temp].size(); i++) {
				if(visit[list[temp].get(i)]) continue;
				visit[list[temp].get(i)] = true;
				sb.append((list[temp].get(i)+1)+" ");
				checkList.add(list[temp].get(i));
			}
		}
	}

	static void dfs(int idx) {
		sb.append((idx+1)+" ");
		visit[idx] = true;
		
		for(int i=0; i<list[idx].size(); i++) {
			if(visit[list[idx].get(i)]) continue;
			
			visit[list[idx].get(i)] = true;
			dfs(list[idx].get(i));
		}
		
	}
}
