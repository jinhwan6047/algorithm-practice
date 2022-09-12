package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj21922_학부연구생민상 {
	static int n, m;
	static int[][] map;
	static boolean[][] uVisit;
	static boolean[][] rVisit;
	static boolean[][] dVisit;
	static boolean[][] lVisit;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		uVisit = new boolean[n][m];
		rVisit = new boolean[n][m];
		dVisit = new boolean[n][m];
		lVisit = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 9) {
					uVisit[i][j] = true;
					rVisit[i][j] = true;
					dVisit[i][j] = true;
					lVisit[i][j] = true;
					upWind(i, j);
					rightWind(i, j);
					downWind(i, j);
					leftWind(i, j);
				}
			}
		}
		
		int cnt=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(uVisit[i][j] || rVisit[i][j] || dVisit[i][j] || lVisit[i][j]) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}

	public static void leftWind(int x, int y) {
		int ny = y-1;
		
		if(ny>=0 && !lVisit[x][ny]) {
			lVisit[x][ny] = true;
			int num = map[x][ny];
			if(num == 1) {
				return;
			}else if(num == 3) {
				downWind(x, ny);				
			}else if(num == 4) {
				upWind(x, ny);
			}else {
				leftWind(x, ny);
			}
		}
		
	}

	public static void downWind(int x, int y) {
		int nx = x+1;
		
		if(nx<n && !dVisit[nx][y]) {
			dVisit[nx][y] = true;
			int num = map[nx][y];
			if(num == 2) {
				return;
			}else if(num == 3) {
				leftWind(nx, y);
			}else if(num == 4) {
				rightWind(nx, y);
			}else {
				downWind(nx, y);
			}
		}
		
	}

	public static void rightWind(int x, int y) {
		int ny = y+1;
		
		if(ny<m && !rVisit[x][ny]) {
			rVisit[x][ny] = true;
			int num = map[x][ny];
			if(num == 1) {
				return;
			}else if(num == 3) {
				upWind(x, ny);
			}else if(num == 4) {
				downWind(x, ny);
			}else {
				rightWind(x, ny);
			}
		}
		
	}

	public static void upWind(int x, int y) {
		int nx = x-1;
		
		if(nx>=0 && !uVisit[nx][y]) {
			uVisit[nx][y] = true;
			int num = map[nx][y];
			if(num == 2) {
				return;
			}else if(num == 3) {
				rightWind(nx, y);
			}else if(num == 4) {
				leftWind(nx, y);
			}else {
				upWind(nx, y);
			}
		}
		
	}
}
