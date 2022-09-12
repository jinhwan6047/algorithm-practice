package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2146_다리만들기 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int cnt;
	static int minNum;
	static int sNum;
	
	static class pos{
		int x;
		int y;
		int dis;
		
		pos(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		pos(int x, int y, int dis){
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visit = new boolean[n][n];
		cnt = 0;
		minNum = 10000;
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					cnt++;
					searchMap(i, j);									
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				visit = new boolean[n][n];
				if(map[i][j] != 0 && !visit[i][j]) {
					sNum = map[i][j];
					makeBridge(i, j);
				}
			}
		}
		
		System.out.println(minNum-1);
		
	}

	static void makeBridge(int x, int y) {
		Queue<pos> list = new LinkedList<>();
		list.add(new pos(x, y, 0));
		visit[x][y] = true;
		
		while(!list.isEmpty()) {
			pos temp = list.poll();
			for(int i=0; i<4; i++) {
				int nx = temp.x+dx[i];
				int ny = temp.y+dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny]!=sNum && !visit[nx][ny]) {
					visit[nx][ny]=true;
					pos p = new pos(nx,ny,temp.dis+1);
					list.add(p);
					if(map[nx][ny] != 0 && map[nx][ny] != sNum) {
						minNum = Math.min(minNum, p.dis);
					}
				}
			}
		}
	}

	static void searchMap(int x, int y) {
		Queue<pos> list = new LinkedList<>();
		list.add(new pos(x, y));
		map[x][y] = cnt;
		visit[x][y] = true;
		
		while(!list.isEmpty()) {
			pos temp = list.poll();
						
			for(int i=0; i<4; i++) {
				int nx = temp.x+dx[i];
				int ny = temp.y+dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny]==1 && !visit[nx][ny]) {
					map[nx][ny]=cnt;
					visit[nx][ny]=true;
					list.add(new pos(nx,ny));
				}
			}
		}
		
	}
}
