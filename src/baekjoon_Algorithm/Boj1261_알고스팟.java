package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1261_알고스팟 {
	static int n, m;
	static int[][] map;
	static boolean [][] visit;
	static int[] d = {0,0,1,-1};
	
	static class pos implements Comparable<pos> {
		int x;
		int y;
		int cnt;
		public pos(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
		@Override
		public 
		int compareTo(pos o) {
			return this.cnt - o.cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		search();
	}
	
	public static void search() {
		Queue<pos> list = new PriorityQueue<>();
		list.add(new pos(0,0,0));
		visit[0][0] = true;
		
		while(!list.isEmpty()) {
			pos temp = list.poll();
			if(temp.x == n-1 && temp.y == m-1) {
				System.out.println(temp.cnt);
				return;
			}
			int nx;
			int ny;
			for(int i=0; i<4; i++) {
				nx = temp.x+d[i];
				ny = temp.y+d[3-i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<m && !visit[nx][ny]) {
//					System.out.println(nx+" : "+ny);
					visit[nx][ny] = true;
					if(map[nx][ny] == 0) {
						list.add(new pos(nx, ny, temp.cnt));
					}else {
						list.add(new pos(nx, ny, temp.cnt+1));
					}
					
				}
			}
		}
	}
}
