package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj22857_가장긴짝수연속한부분수열small {
	static StringBuilder sb = new StringBuilder();
	static int n,k;
	static int[] s;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		s = new int[n+1];
		dp = new int[k+2][n+1];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=1; i<n+1; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		int max=0;
		for(int i=1; i<=k+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(s[j]%2==0) {
					dp[i][j] = dp[i][j-1]+1; 
				}else {
					dp[i][j] = dp[i-1][j-1];
				}
				max = Math.max(max, dp[i][j]);
			}

		}
		
		System.out.println(max);
		
	}
}
