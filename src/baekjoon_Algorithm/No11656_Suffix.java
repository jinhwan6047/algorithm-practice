package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No11656_Suffix {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] arr = new String[str.length()];
		
		for(int i=0; i<str.length(); i++) {
			arr[i] = str.substring(i);
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<str.length(); i++) {
			sb.append(arr[i]).append("\n");
		}
		
		System.out.println(sb);
	}
}
