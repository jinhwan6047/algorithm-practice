package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj13549_숨바꼭질3 {
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
			if(p.x == k) {
				System.out.println(p.cnt);
				return;
			}
			for(int i=0; i<3; i++) {
				int nx;
				if(i>0) {
					nx = p.x+dx[i-1];
					
				}else {
					nx = p.x*2;
				}
				
				if(nx>=0 && nx<100001 && !visit[nx]) {
					visit[nx] = true;
					if(i == 0) {
						list.add(new pos(nx, p.cnt));
					}else {
						list.add(new pos(nx, p.cnt+1));							
					}
				}
			}
		}
	}
}

