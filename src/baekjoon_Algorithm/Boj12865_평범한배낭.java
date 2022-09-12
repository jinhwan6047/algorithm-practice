package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12865_평범한배낭 {
	static StringBuilder sb = new StringBuilder();
	static int n,k;
	static int[] w,v;
	static Integer[][] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		dp = new Integer[n+1][k+1];
		
		w = new int[n+1];
		v = new int[n+1];
		for(int i=1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine()," ");
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(search(n, k));
		
	}

	private static int search(int num, int kNum) {
		if(num == 0) {
			dp[num][kNum] = 0;
		}
			
		if(dp[num][kNum] == null) {
			if(w[num]>kNum) {
				dp[num][kNum] = search(num-1, kNum);
			}else {
				dp[num][kNum] = Math.max(search(num-1, kNum), search(num-1, kNum-w[num])+v[num]);
			}
		}
		return dp[num][kNum];
	}
}
