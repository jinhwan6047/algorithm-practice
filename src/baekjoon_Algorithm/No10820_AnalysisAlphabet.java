package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class No10820_AnalysisAlphabet {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str;
		// a ~ z : 97 ~ 122
        // A ~ Z : 65 ~ 90
        // 0 ~ 9 : 48 ~ 57
        // ' ' : 32
		
		while((str=br.readLine()) != null) {
			int[] result = new int[4];
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<str.length(); i++) {
				if((int)str.charAt(i)>=97 && (int)str.charAt(i)<=122) {
					result[0]++;
				}else if((int)str.charAt(i)>=65 && (int)str.charAt(i)<=90) {
					result[1]++;
				}else if((int)str.charAt(i)>=48 && (int)str.charAt(i)<=57) {
					result[2]++;
				}else {
					result[3]++;
				}
			}
			sb.append(result[0]).append(" ").append(result[1]).append(" ").append(result[2]).append(" ").append(result[3]);
			System.out.println(sb);
		}	
	}
}
