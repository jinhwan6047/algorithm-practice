package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj2250_트리의높이와너비 {
	static StringBuilder sb = new StringBuilder();
	static node[] list;
	static int cnt, maxLv, startNode;
	static boolean[] visit;
	static ArrayList<Integer>[] level;

	public static class node{
		Integer left, right, x, y;

		public node(Integer left, Integer right, Integer x, Integer y) {
			super();
			this.left = left;
			this.right = right;
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		list = new node[n+1];
		level = new ArrayList[n+1];
		visit = new boolean[n+1];
		visit[0] = true;
		startNode = 1;
		maxLv = 0;
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int num3 = Integer.parseInt(st.nextToken());
			list[num1] = new node(num2, num3, null, null);
			
			if(num2 != -1)
				visit[num2] = true;
			if(num3 != -1)
				visit[num3] = true;
			
			level[i] = new ArrayList<Integer>();
		}
		level[n] = new ArrayList<Integer>();
		
		for(int i=1; i<n+1; i++) {
			if(!visit[i]) {
				startNode = i;
				break;
			}		
		}
				
		cnt=1;
		positioning(startNode,1);
		
		searchWidth();
	}
	
	public static void searchWidth() {
		int maxWidth=0; 
		int idx=1;
		
		for(int i=1; i<maxLv+1; i++) {
			int num = level[i].get(level[i].size()-1) - level[i].get(0)+1;
			if(maxWidth<num) {
				maxWidth = num;
				idx = i;
			}
		}
		
		System.out.println(idx+" "+maxWidth);
		
	}
	public static void positioning(int num, int lv) {
		maxLv = Math.max(maxLv, lv);
		if(list[num].left != -1) {
			positioning(list[num].left, lv+1);
		}
		list[num].x = cnt;
		cnt++;
		level[lv].add(list[num].x);
		if(list[num].right != -1) {
			positioning(list[num].right, lv+1);
		}
	}
}
