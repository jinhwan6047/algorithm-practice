package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1149_RGB거리 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1][3];
		
		for(int i=1; i<n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n0 = Integer.parseInt(st.nextToken());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			dp[i][0] = n0 + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = n1 + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = n2 + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
	}
}
