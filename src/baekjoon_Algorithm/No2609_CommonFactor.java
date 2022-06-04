package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2609_CommonFactor {
	static StringBuilder sb = new StringBuilder();
	static int n1;
	static int n2;

	static void func(int num1, int num2) {
		// TODO Auto-generated method stub
		if(num1%num2 == 0) {
			sb.append(num2).append("\n").append(n1*n2/num2);
			return;
		}
		func(num2, num1%num2);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		String[] arr = str.split(" ");
		int num1 = Integer.parseInt(arr[0]);
		int num2 = Integer.parseInt(arr[1]);
		n1 = num1;
		n2 = num2;
		
		
		func(num1, num2);
		
		System.out.println(sb);
	}

}
