package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9613_GCDSum {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			String[] arr = str.split(" ");
			long sum=0;
			for(int j=1; j<Integer.parseInt(arr[0]); j++) {
				for(int k = j+1; k<Integer.parseInt(arr[0])+1; k++) {
					sum += gcd_func(Integer.parseInt(arr[j]),Integer.parseInt(arr[k]));
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

	static int gcd_func(int num1, int num2) {
		// TODO Auto-generated method stub
		if(num1%num2 == 0) {
			return num2;
		}
		return gcd_func(num2, num1%num2);
	}
}
