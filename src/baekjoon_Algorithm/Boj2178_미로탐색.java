/**
 * dfs방식 시간초과
 */
package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2178_미로탐색 {
	static StringBuilder sb = new StringBuilder();
	static int n,m; //입력 받는 가로 세로
	static int[][] map; // 입력받는 미로 지도
	static boolean[][] visit; //방문여부 체크
	static int minNum;//최소 이동값 체크
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m];
		minNum = n*m;
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		visit[0][0] = true;
		searchMap(0, 0, 1);
		
		
		System.out.println(minNum);
	}

	static void searchMap(int row, int col, int cnt) {
		if(row == n-1 && col == m-1) {
			minNum = Math.min(minNum, cnt);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nx = row+dx[i];
			int ny = col+dy[i];
			
			if(nx>=0 && ny>=0 && nx<n && ny<m && !visit[nx][ny] && map[nx][ny]==1) {
				visit[nx][ny] = true;
				searchMap(nx, ny, cnt+1);
				visit[nx][ny] = false;
			}
		}
		
	}
}
