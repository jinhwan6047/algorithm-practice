package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj22858_원상복구small {
	static StringBuilder sb = new StringBuilder();
	static int n,k; //n:카드수, k:섞은 횟수
	static int[] s, d; //s:k번 섞은 후 카드 순서, d:카드섞는 방향
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		dp = new int[k+1][n+1];
		s = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++) {
			s[i] = Integer.parseInt(st.nextToken());
			dp[k][i] = s[i];
		}
		
		d = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=k-1; i>=0; i--) {
			for(int j=1; j<n+1; j++) {
				dp[i][d[j]] = dp[i+1][j];
			}
		}
		
		for(int i=1; i<n+1; i++) {
			System.out.print(dp[0][i]+" ");
		}
	}
}
