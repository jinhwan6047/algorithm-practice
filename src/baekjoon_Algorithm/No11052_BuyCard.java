package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class No11052_BuyCard {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		String[] strArr = str.split(" ");
		
		int[] dp = new int[n+1];

		for(int i=1; i<n+1; i++) {
			ArrayList<Integer> numList = new ArrayList<>();
			for(int j=1; j<i; j++) {
				numList.add(dp[j]+dp[i-j]);				
			}
			numList.add(Integer.parseInt(strArr[i-1]));
			dp[i]=Collections.max(numList);
		}
		
		System.out.println(dp[n]);
	}
}
