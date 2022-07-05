package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No6064 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			sb.append(searchYear(n,m,x,y)).append("\n");
		}
		
		System.out.println(sb);
		
	}

	static int searchYear(int n, int m, int x, int y) {
		int cnt = 1;
		int nx=1, ny=1;
		
		while(true) {
			if(nx == x && ny == y) {
				return cnt;
			}
			if(nx == n && ny == m && x != n && y != m) {
				return -1;
				
			}
			if(nx > n) {
				nx=1;
			}
			if(ny > m) {
				ny=1;
			}
			nx++; ny++; cnt++;
		}
	}
	
	
}
