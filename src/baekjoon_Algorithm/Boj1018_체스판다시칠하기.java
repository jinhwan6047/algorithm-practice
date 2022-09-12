package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj1018_체스판다시칠하기 {
	static StringBuilder sb = new StringBuilder();
	static int n,m;
	static char[][] map;
	static int minNum = 64;
	static boolean[][] visit;
	static int[] d= {1,0};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		n = Integer.parseInt(str.split(" ")[0]);
		m = Integer.parseInt(str.split(" ")[1]);
		
		map = new char[n][m];
		
		for(int i=0; i<n; i++) {
			str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(i+7<n && j+7<m) {
					searchMap(i ,j);
				}
			}
		}
		System.out.println(minNum);
	}
	
	public static class Pos{
		int x;
		int y;
		char color;
		public Pos(int x, int y, char color) {
			super();
			this.x = x;
			this.y = y;
			this.color = color;
		}
	}

	public static void searchMap(int x, int y) {
		Queue<Pos> list = new LinkedList<>();
		visit = new boolean[n][m];
		visit[x][y] = true;
		int cnt=0;
		list.add(new Pos(x, y, map[x][y]));
		
		while(!list.isEmpty()) {
			Pos temp = list.poll();
			for(int i=0; i<2; i++) {
				int nx = temp.x+d[i];
				int ny = temp.y+d[1-i];
				char color = temp.color;
				char countColor='0';
				if(color == 'W') {
					countColor = 'B';
				}else if(color == 'B') {
					countColor ='W';
				}
				
				if(nx-x<8 && ny-y<8 && !visit[nx][ny]) {
					if(map[nx][ny] == color) {
						cnt++;
						visit[nx][ny] = true;
						list.add(new Pos(nx, ny, countColor));
					}else {
						visit[nx][ny] = true;
						list.add(new Pos(nx, ny, map[nx][ny]));
					}
				}
			}
		}

		cnt = Math.min(64-cnt, cnt);
		minNum = Math.min(minNum, cnt);
		
	}
}
