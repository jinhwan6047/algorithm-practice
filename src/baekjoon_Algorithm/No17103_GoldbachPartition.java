package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No17103_GoldbachPartition {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			int number = Integer.parseInt(br.readLine());
			int cnt = 0;
			int chkNum = number - 3;
			while(chkNum>=(number/2)) {
				if(isPrime(chkNum)) {
					if(isPrime(number-chkNum)) {
						cnt++;
					}
				}
				chkNum -= 2;
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
		
	}
	

	
	static boolean isPrime(int temp) {
		for(int i=2; i<=Math.sqrt(temp); i++) {
			if(temp % i == 0) {
				return false;
			}
		}
		return true;
	}
}
