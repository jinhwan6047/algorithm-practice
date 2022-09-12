package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj11724_연결요소의개수 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static int cnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visit = new boolean[n];
		list = new ArrayList[n];
		for(int i=0; i<n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int num1 = Integer.parseInt(st.nextToken())-1;
			int num2 = Integer.parseInt(st.nextToken())-1;
			
			list[num1].add(num2);
			list[num2].add(num1);
		}
		
		for(int i=0; i<n; i++) {
			if(!visit[i]) {
				cnt++;
				searchConn(i);
			}
		}
		
		System.out.println(cnt);
				
	}

	static void searchConn(int idx) {
		
		visit[idx] = true;
		for(int i=0; i<list[idx].size(); i++) {
			if(visit[list[idx].get(i)]) continue;
			visit[list[idx].get(i)] = true;
			searchConn(list[idx].get(i));
			
		}
	}
}
