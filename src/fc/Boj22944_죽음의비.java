package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj22944_죽음의비 {
	static StringBuilder sb = new StringBuilder();
	static int n,h,d;
	static char[][] map;
	static boolean[][] visit;
	static int result = -1;
	static int[] w= {1, -1, 0, 0};
	
	public static class Pos implements Comparable<Pos>{
		int x;
		int y;
		int hlth;
		int um;
		int cnt;
		
		public Pos(int x, int y, int hlth, int um, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.hlth = hlth;
			this.um = um;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Pos o) {
			// TODO Auto-generated method stub
			if(o.hlth == this.hlth) {
				return this.cnt - o.cnt;
			}else {
				return o.hlth-this.hlth;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new char[n][n];
		visit = new boolean[n][n];
		
		int x=0;
		int y=0;
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'S') {
					x = i;
					y = j;
				}
			}
		}
		
		search(x, y);
		
		System.out.println(result);
		
		
	}

	private static void search(int x, int y) {
		Queue<Pos> list = new PriorityQueue<>();
		list.add(new Pos(x,y,h,0,0));
		
		while(!list.isEmpty()) {
			Pos p = list.poll();
			for(int i=0; i<4; i++){
				int nx = p.x+w[i];
				int ny = p.y+w[3-i];
				if(nx>=0 && nx<n && ny>=0 && ny<n && !visit[nx][ny]) {
					visit[nx][ny] = true;
					if(map[nx][ny] == 'E') {
						result = p.cnt+1;
						return;
					}else if(map[nx][ny] == '.') {
						if(p.um>0) {
							list.add(new Pos(nx,ny,p.hlth,p.um-1,p.cnt+1));
						}else {
							if(p.hlth == 1) {
								visit[nx][ny] = false;
								continue;
							}else {
								list.add(new Pos(nx,ny,p.hlth-1,p.um,p.cnt+1));
							}
						}
					}else if(map[nx][ny] == 'U') {
						list.add(new Pos(nx,ny,p.hlth,d,p.cnt+1));
					}
				}
			}
		}
		
	}
}
