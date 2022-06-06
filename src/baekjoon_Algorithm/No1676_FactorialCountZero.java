package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1676_FactorialCountZero {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int result =0;
		if(n==0) {
			result = 1;
		}else {			
			while(n>=5) {
				result += n/5;
				n /= 5;
			}
		}
		
		System.out.println(result);
	}

}
