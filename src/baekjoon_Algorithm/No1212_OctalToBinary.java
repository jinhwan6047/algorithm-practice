package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1212_OctalToBinary {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			String temp = Integer.toBinaryString(Integer.parseInt((String.valueOf(str.charAt(i)))));
			if(temp.length() == 1) {
				sb.append("00").append(temp);
			}else if(temp.length() == 2) {
				sb.append("0").append(temp);
			}else {
				sb.append(temp);
			}
		}
		while(sb.charAt(0) == '0'&&sb.length()>1) {
			sb.deleteCharAt(0);
		}
		
		System.out.println(sb);
	}
}
