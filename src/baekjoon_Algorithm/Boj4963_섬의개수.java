package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj4963_섬의개수 {
	static StringBuilder sb = new StringBuilder();
	static int w,h; //입력받은 가로, 세로
	static int[][] map; //입력 받은 지도
	static boolean[][] visit; //방문여부 체크 
	static int cnt; //섬의 갯수
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) {
				//w,h가 0 0일때 종료
				break;
			}
			map = new int[h][w];
			visit = new boolean[h][w];
			cnt = 0;
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(!visit[i][j] && map[i][j] == 1) {
						searchMap(i, j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");		
		}
		System.out.println(sb);
			
	}

	static void searchMap(int row, int col) {
		visit[row][col] = true;
		
		//아래로 탐색
		if(row<h-1 && !visit[row+1][col] && map[row+1][col] == 1) {
			searchMap(row+1, col);
		}
		
		//위로 탐색
		if(row>0 && !visit[row-1][col] && map[row-1][col] == 1) {
			searchMap(row-1, col);
		}
		
		//우측 탐색
		if(col<w-1 && !visit[row][col+1] && map[row][col+1] == 1) {
			searchMap(row, col+1);
		}
		
		//좌측 탐색
		if(col>0 && !visit[row][col-1] && map[row][col-1] == 1) {
			searchMap(row, col-1);
		}
		
		//좌상 탐색
		if(row >0 && col >0 && !visit[row-1][col-1] && map[row-1][col-1] == 1) {
			searchMap(row-1, col-1);
		}
		
		//좌하 탐색
		if(row <h-1 && col >0 && !visit[row+1][col-1] && map[row+1][col-1] == 1) {
			searchMap(row+1, col-1);
		}
		
		//우상 탐색
		if(row >0 && col <w-1 && !visit[row-1][col+1] && map[row-1][col+1] == 1) {
			searchMap(row-1, col+1);
		}
		
		//우하 탐색
		if(row <h-1 && col <w-1 && !visit[row+1][col+1] && map[row+1][col+1] == 1) {
			searchMap(row+1, col+1);
		}
	}
}
