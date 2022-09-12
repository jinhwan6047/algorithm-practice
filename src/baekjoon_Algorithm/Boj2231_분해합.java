package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2231_분해합 {
	static StringBuilder sb = new StringBuilder();
	static int n;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		int pow = powFunc(n);
		int startNum = n-9*pow;
		
		int result = search(startNum, pow);
		
		System.out.println(result);
		
	}

	private static int search(int startNum, int pow) {
		
		for(int i=startNum; i<n; i++) {
			int num = i;
			int sum=0;
			while(num!=0) {
				sum += num%10;
				num /= 10;
			}
			if((sum+i) == n) return i;
		}
		
		return 0;
	}

	private static int powFunc(int num) {
		int result=1;
		
		while(num/10 != 0) {
			num /= 10;
			result++;
		}
		
		return result;
	}
}
