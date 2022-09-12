package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1904_01타일 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[1000001];
		Arrays.fill(dp, -1);
		
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		
		System.out.println(fib(n));
		
	}

	private static int fib(int num) {
		if(dp[num] == -1) {
			dp[num] = (fib(num-1)+fib(num-2))%15746;
		}
		return dp[num]%15746;		
	}
}
