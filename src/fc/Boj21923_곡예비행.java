package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj21923_곡예비행 {
	static int n, m;
	static int[][] map;
	static int maxSum=-10000000;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		upFly(n-1, 0, map[n-1][0]);
		
		System.out.println(maxSum);
	}

	private static void upFly(int x, int y, int sum) {
		int nx=x-1;
		int ny=y+1;
		
		if(nx>=0) {
			upFly(nx, y, sum+map[nx][y]);
		}
		
		if(ny<m) {
			upFly(x, ny, sum+map[x][ny]);		
		}
		
		downFly(x, y, sum+map[x][y]);
	}

	private static void downFly(int x, int y, int sum) {
		if(x==n-1 &&y==m-1) {
			maxSum = Math.max(maxSum, sum);
		}
		
		int nx = x+1;
		int ny = y+1;
		
		if(nx<n) {
			downFly(nx, y, sum+map[nx][y]);		
		}
		
		if(ny<m) {
			downFly(x, ny, sum+map[x][ny]);	
		}
	}
}
