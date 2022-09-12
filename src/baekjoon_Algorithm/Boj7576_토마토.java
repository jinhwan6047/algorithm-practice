package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj7576_토마토 {
	static StringBuilder sb = new StringBuilder();
	static int m,n;//가로, 세로 입력
	static int[][] map;//지도 입력
	static boolean[][] visit; //방문여부
	static ArrayList<Integer> xList = new ArrayList<Integer>(); //탐색 순서 저장
	static ArrayList<Integer> yList = new ArrayList<Integer>(); //탐색 순서 저장

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
				if(map[i][j] == 1) {
					xList.add(i);
					yList.add(j);
				}
			}
		}
		
		srcMap();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(map[i][j]);
			System.out.println();
			}
		}
	}

	static void srcMap() {
		int[] dx = {0,0,1,-1}; //방향
		int[] dy = {1,-1,0,0}; //방향
		
		while(!xList.isEmpty()) {
			int x = xList.remove(0);
			int y = yList.remove(0);
			
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					if(map[nx][ny] == -1) {
						visit[nx][ny] = true;
						continue;
					}
					if(!visit[nx][ny] && map[nx][ny] == 0) {
						xList.add(nx);
						yList.add(ny);
						 map[nx][ny] =  map[x][y]+1;
						visit[nx][ny] = true;
					}
				}
			}
		}
		
	}
}
