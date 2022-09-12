package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj22866_탑보기 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] building;
	static int[][] near;
	static int[] cntBuild;
	
	public static class Build{
		int no;
		int hight;
		public Build(int no, int hight) {
			super();
			this.no = no;
			this.hight = hight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		building = new int[n+1];
		near = new int[n+1][2]; //[a][b] a:건물번호, b0:가까운 건물번호, b1:거리
		cntBuild = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1; i<n+1; i++) {
			building[i] = Integer.parseInt(st.nextToken());
			near[i][0]=Integer.MAX_VALUE;
			near[i][1]=Integer.MAX_VALUE;
		}
		
		searchLeft();
		searchRight();
		
		for(int i=1; i<n+1; i++) {
			if(cntBuild[i] !=0)
				System.out.println(cntBuild[i]+" "+near[i][0]);
			else
				System.out.println(cntBuild[i]);
		}
		
	}

	private static void searchRight() {
		Stack<Build> stk = new Stack<>();
		for(int i=n; i>0; i--) {
			while(!stk.isEmpty() && stk.peek().hight<=building[i]) {
				stk.pop();
			}
			
			if(!stk.isEmpty()) {
				int gap = stk.peek().no-i;
				if(gap<near[i][1]) {
					near[i][0] = stk.peek().no;
					near[i][1] = gap;
				}else if(gap == near[i][1]) {
					if(stk.peek().no < near[i][0]) {
						near[i][0] = stk.peek().no;
					}
				}
			}
			
			cntBuild[i] += stk.size();
			stk.add(new Build(i, building[i]));
		}
		
	}

	private static void searchLeft() {
		Stack<Build> stk = new Stack<>();
		for(int i=1; i<n+1; i++) {
			while(!stk.isEmpty() && stk.peek().hight<=building[i]) {
				stk.pop();
			}	
			if(!stk.isEmpty()) {
				int gap = i-stk.peek().no;
				if(gap<near[i][1]) {
					near[i][0] = stk.peek().no;
					near[i][1] = gap;
				}else if(gap == near[i][1]) {
					if(stk.peek().no < near[i][0]) {
						near[i][0] = stk.peek().no;
					}
				}
			}
			
			cntBuild[i] = stk.size();
			stk.add(new Build(i, building[i]));
		}
	}
}
