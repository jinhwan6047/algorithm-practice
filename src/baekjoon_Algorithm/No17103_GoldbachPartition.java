package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No17103_GoldbachPartition {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//소수 배열 만들기 -> 소수 : false
		boolean[] isPrime = new boolean[1000001];
		
		isPrime[0] = isPrime[1] = true;
		for(int i=2; i<isPrime.length; i++) {
			if(!isPrime[i]) {
				for(int j=i+i; j<isPrime.length; j+=i) {
					isPrime[j] = true;
				}				
			}
		}
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			int chkNum = num-1;
			int cnt=0;
			while(chkNum>=num/2) {
				if(!isPrime[chkNum]&&!isPrime[num-chkNum]) {
					cnt++;
				}
				chkNum--;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}	 
}
