package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj9184_신나는함수실행 {
	static StringBuilder sb = new StringBuilder();
	static Integer[][][] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp = new Integer[51][51][51];
		int a=0,b=0,c=0;
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			
			if(a==-1 && b==-1 && c==-1) break;
			
			sb.append("w("+a+", "+b+", "+c+") = ").append(w(a,b,c)).append("\n");
		}
		
		System.out.println(sb);
		
	}


	private static int w(int a, int b, int c) {
		if(a<=0 || b<=0 || c<=0) return 1;
		
		if(a>20 || b>20 || c>20) return w(20,20,20);
		
		if(dp[a][b][c] == null) {
			if(a < b && b < c) dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
			else dp[a][b][c] =   w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
		}
			
		return dp[a][b][c];
	}
}
