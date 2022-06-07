package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11653_Factorization {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int num=2;
		while(n>1) {
			if(n%num == 0) {
				sb.append(num).append("\n");
				n /= num;
			}else {
				num++;
			}
		}
		
		System.out.println(sb);
	}
}
