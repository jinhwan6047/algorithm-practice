package pgms;

import java.util.LinkedList;
import java.util.Queue;

public class Pgms1844_게임맵최단거리 {
	public static void main(String[] args) {
//		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
//		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		int[][] maps = {{1,1},{1,1}};
		
		Pgms1844_게임맵최단거리 sol = new Pgms1844_게임맵최단거리();
		System.out.println(sol.solution(maps));
	}
	
	public class Pos{
		int x;
		int y;
		int cnt;
		public Pos(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	boolean[][] visit;
	int[] d = {1,-1,0,0};
	
	public int solution(int[][] maps) {		
		int answer = -1;
		int n = maps.length;
		int m = maps[0].length;
		visit = new boolean[n][m];
		
		Queue<Pos> list = new LinkedList<>();
		list.add(new Pos(0, 0, 1));
		
		while(!list.isEmpty()) {
			Pos cp = list.poll();
			for(int i=0; i<4; i++) {
				int nx = cp.x+d[i];
				int ny = cp.y+d[3-i];
				if(nx>=0 && nx<n && ny>=0 && ny<m) {
					if(maps[nx][ny]==1 && !visit[nx][ny]) {
						if(nx==n-1 && ny==m-1) {
							answer = cp.cnt+1;
							return answer;
						}
						visit[nx][ny] = true;
						list.add(new Pos(nx, ny, cp.cnt+1));					
					}
				}
			}
		}
		
				
		return answer;
	}
}
