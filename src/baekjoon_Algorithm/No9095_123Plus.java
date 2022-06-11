package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9095_123Plus {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			int[] dp = new int[num+1];
			dp[0]=0; dp[1]=1; dp[2]=2; dp[3]=4;
			
			for(int j=4; j<num+1; j++) {
				dp[j] = dp[j-1]+dp[j-2]+dp[j-3];
			}
			sb.append(dp[num]).append("\n");
		}
		
		System.out.println(sb);
	}
}
