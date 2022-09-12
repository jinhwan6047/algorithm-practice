package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2667_단지번호붙이기 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
			
		}
		
		
		for(int i=0; i<n; i++) {			
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j]);		
			}
			System.out.println();
		}
	}
}
