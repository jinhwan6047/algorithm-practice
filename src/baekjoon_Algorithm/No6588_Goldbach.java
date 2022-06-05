package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No6588_Goldbach {
	static StringBuilder sb = new StringBuilder();
	static int checkNum;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while((checkNum= Integer.parseInt(br.readLine())) != 0) {
			int number = func(checkNum-1);
			sb.append(checkNum).append(" = ").append(checkNum-number).append(" + ").append(number).append("\n");		
		}
		
		
//		for(int i=6; i<1000001; i+=2) {
//			checkNum = i;
//			int number = func(i-1);
//			
//			sb.append(i).append(" = ").append(i-number).append(" + ").append(number).append("\n");	
//		}

		System.out.println(sb);
		
	}

	static int func(int n) {
		// TODO Auto-generated method stub
		int num = n-2;
		boolean flag = isPrime(num);
		if(flag) {
			if(isPrime(checkNum-num)) {
				return num;
			}
		}
		return func(num);
		
	}
	
	static boolean isPrime(int num) {
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i == 0) {
				return false;
			}
		}
		return true;
	}
}
