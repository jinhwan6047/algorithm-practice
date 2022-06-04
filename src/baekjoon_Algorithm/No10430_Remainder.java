package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10430_Remainder {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		String[] arr = str.split(" ");
		
		int A = Integer.parseInt(arr[0]);
		int B = Integer.parseInt(arr[1]);
		int C = Integer.parseInt(arr[2]);
		
		sb.append((A+B)%C).append("\n").append(((A%C) + (B%C))%C).append("\n").append((A*B)%C).append("\n").append(((A%C) * (B%C))%C);
		
		System.out.println(sb);
	}
}
