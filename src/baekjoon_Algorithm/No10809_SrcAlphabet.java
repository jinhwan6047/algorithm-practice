package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No10809_SrcAlphabet {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] sArr = new int[26];
		Arrays.fill(sArr, -1);
		
		for(int i=0; i<s.length(); i++) {
			if(sArr[(int)s.charAt(i)-97] == -1) {
				sArr[(int)s.charAt(i)-97] = i;				
			}
		}
		
		for(int i=0; i<26; i++) {
			sb.append(sArr[i]).append(" ");
		}
		
		System.out.println(sb);
	}
	
}
