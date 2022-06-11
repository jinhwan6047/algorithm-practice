package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2193_Binary {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long[][] arr = new long[n+1][2];
		arr[1][1] = 1;
		
		for(int i=2; i<n+1; i++) {
			arr[i][0] = arr[i-1][0]+arr[i-1][1];
			arr[i][1] = arr[i-1][0];
		}
		
		long result = arr[n][0]+arr[n][1];
		
		System.out.println(result);
	}
}
