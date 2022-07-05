package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj13023_ABCDE {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static boolean[] visit;
	static ArrayList<Integer>[] list;
	static int result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result = 0;
		
		list = new ArrayList[n];
		for(int i=0; i<n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			list[num1].add(num2);
			list[num2].add(num1);
		}
		
		for(int i=0; i<n; i++) {
			visit = new boolean[n];
			dfs(i,0);
			
			if(result == 1) break;
		}
		
		System.out.println(result);
	}

	static void dfs(int idx, int depth) {
		if(depth == 4) {
			result = 1;
			return;
		}
		visit[idx] = true;
		for(int i=0; i<list[idx].size(); i++) {
			if(visit[list[idx].get(i)]) continue;
			
			visit[list[idx].get(i)] = true;
			dfs(list[idx].get(i), depth+1);
			visit[list[idx].get(i)] = false;
		}
		
	}
	
}
