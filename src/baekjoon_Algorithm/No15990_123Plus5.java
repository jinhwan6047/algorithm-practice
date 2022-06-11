package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No15990_123Plus5 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[100001][4];
		arr[1][1] = 1;
		arr[2][2] = 1;
		arr[3][1] = 1;
		arr[3][2] = 1;
		arr[3][3] = 1;		
		for(int i=4; i<100001; i++) {
			arr[i][1] = (arr[i-1][2])%1000000009+(arr[i-1][3])%1000000009;
			arr[i][2] = (arr[i-2][1])%1000000009+(arr[i-2][3])%1000000009;
			arr[i][3] = (arr[i-3][1])%1000000009+(arr[i-3][2])%1000000009;
		}
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			long result = 0;
			for(int j=1; j<4; j++) {
				result += (arr[num][j])%1000000009;
			}
			sb.append(result%1000000009).append("\n");
		}
		System.out.println(sb);
	}
}
