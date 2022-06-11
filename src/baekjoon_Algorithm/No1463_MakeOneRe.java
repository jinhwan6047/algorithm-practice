package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class No1463_MakeOneRe {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		dp[0] = dp[1] = 0;
		for(int i=2; i<=n; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			if(i%3==0) {
				temp.add(dp[i/3]+1);
			}
			if(i%2==0) {
				temp.add(dp[i/2]+1);
			}
			temp.add(dp[i-1]+1);
			dp[i] = Collections.min(temp);
		}
		
		System.out.println(dp[n]);
	}
}
