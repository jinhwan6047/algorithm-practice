package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10824_FourNumber {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] arr = str.split(" ");
		
		String num1 = arr[0]+arr[1];
		String num2 = arr[2]+arr[3];
		
		long num = Long.parseLong(num1)+Long.parseLong(num2);
		System.out.println(num);
	}
}
