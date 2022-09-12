package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1697_숨바꼭질 {
	static StringBuilder sb = new StringBuilder();
	static int n, k;//입력 값
	static boolean[] visit = new boolean[100001];
	static int[] dx = {-1,1};
	
	static class pos{
		int x;
		int cnt;

		public pos(int x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		if(n == k) {
			System.out.println("0");
			return;
		}
		search();
	}
	
	static void search() {
		Queue<pos> list = new LinkedList<>();
		list.add(new pos(n, 0));
		visit[n] = true;
		
		while(!list.isEmpty()) {
			pos p = list.poll();
			for(int i=0; i<3; i++) {
				int nx;
				if(i<2) {
					nx = p.x+dx[i];
				}else {
					nx = p.x*2;
				}
				
				if(nx>=0 && nx<100001 && !visit[nx]) {
					if(nx == k) {
						System.out.println(p.cnt+1);
						return;
					}
					visit[nx] = true;
					list.add(new pos(nx, p.cnt+1));
				}
			}
		}
	}
}
