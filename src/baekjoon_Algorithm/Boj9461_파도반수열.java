package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj9461_파도반수열 {
	static StringBuilder sb = new StringBuilder();
	static int t;
	static long[] dp = new long[101];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(fib(n)).append("\n");
		}
		
		System.out.println(sb);
	}

	private static long fib(int n) {
		if(dp[n] == -1) {
			dp[n] = fib(n-2)+fib(n-3);
		}
		
		return dp[n];
	}
}
