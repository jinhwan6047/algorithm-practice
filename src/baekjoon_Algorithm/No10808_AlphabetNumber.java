package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10808_AlphabetNumber {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int[] strArr = new int[26];
		
		for(int i=0; i<str.length(); i++) {
			strArr[(int)str.charAt(i)-97]++;
		}
		for(int i=0; i<strArr.length; i++) {
			sb.append(strArr[i]).append(" ");
		}
		
		System.out.println(sb);
		
	}

}
