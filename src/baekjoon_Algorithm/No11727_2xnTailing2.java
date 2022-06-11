package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11727_2xnTailing2 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		
		for(int i=3; i<n+1; i++) {
			dp[i] = (dp[i-1]+2*dp[i-2])%10007;
		}
		
		System.out.println(dp[n]);
	}
}
