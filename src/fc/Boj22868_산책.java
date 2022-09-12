package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj22868_산책 {
	static StringBuilder sb = new StringBuilder();
	static int n,m,s,e;
	static ArrayList<Integer>[] root;
	static boolean[] visit;
	static int[] history;
	static int cnt;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		root = new ArrayList[n+1];
		for(int i=0; i<n+1; i++) {
			root[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			root[n1].add(n2);
			root[n2].add(n1);
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
		visit[e] = true;
		cnt = 1;
		int chk = e;
		while(history[chk] != s) {
			cnt++;
			chk = history[chk];
			visit[chk] = true;
		}
		
		history = new int[n+1];
		search(e, s);
		
		chk = s;
		cnt++;
		while(history[chk] != e) {
			cnt++;
			chk = history[chk];
		}
		
		System.out.println(cnt);
	}

	private static void search(int start, int end) {
		Queue<Integer> list = new LinkedList<Integer>();
		list.add(start);
		
		while(!list.isEmpty()) {
			int n = list.poll();
			ArrayList<Integer> temp = root[n];
			for(int i=0; i<temp.size(); i++) {
				int tempN = temp.get(i);
				if(!visit[tempN]) {
					visit[tempN] = true;
					history[tempN] = n;
					if(tempN == end) {
						return;
					}
					list.add(tempN);
				}
			}
		}
		
	}
}
