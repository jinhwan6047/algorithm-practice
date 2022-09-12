package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16947_서울지하철2호선 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static ArrayList<Integer>[] list;
	static boolean[] visit;
	static int s;
	static boolean[] cycle;
	static int count;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		cycle = new boolean[n];
		list = new ArrayList[n];				
		for(int i=0; i<n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st; 
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int n1 = Integer.parseInt(st.nextToken())-1;
			int n2 = Integer.parseInt(st.nextToken())-1;
			
			list[n1].add(n2);
			list[n2].add(n1);
		}
		
		for(int i=0; i<n; i++) {
			s =i;
			visit = new boolean[n];
			searchCycle(i, 0);
			
		}
		
		for(int i=0; i<n; i++) {
			if(cycle[i]) {
				sb.append(0+" ");
			}else {
				visit = new boolean[n];
				count = 0;
				findCycle(i, 0);
				sb.append(count+" ");
			}
		}
		System.out.println(sb);
		
	}

	static void findCycle(int o ,int cnt) {
		if(cycle[o]) {
			count = cnt;
			return;
		}
		visit[o] = true;
		
		for(int i=0; i<list[o].size(); i++) {
			int num = list[o].get(i);
			if(!visit[num]) {
				findCycle(num, cnt+1);

			}
		}
	}

	static void searchCycle(int o, int cnt) {
		if(cnt>2 && s == o) {
			cycle[s] = true;
			return;
		}
	
		for(int i=0; i<list[o].size(); i++) {
			int num = list[o].get(i);
			if(!visit[num]) {
				visit[num] = true;
				searchCycle(num, cnt+1);
				visit[num] = false;
			}
		}
	}
}
