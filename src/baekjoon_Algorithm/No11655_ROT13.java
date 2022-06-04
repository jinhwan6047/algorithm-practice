package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11655_ROT13 {
	static StringBuilder sb = new StringBuilder();
	
	static void rot13_func(char c) {
		int num = (int)c;
		
		if(97<=num&&num<=122) {
			if(num+13>122) {
				sb.append((char)(num-13));
			}else {
				sb.append((char)(num+13));
			}
		}else if(65<=num&&num<=90){
			if(num+13>90) {
				sb.append((char)(num-13));
			}else {
				sb.append((char)(num+13));
			}
		}else {
			sb.append(c);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// a ~ z : 97 ~ 122
        // A ~ Z : 65 ~ 90
		
		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			rot13_func(str.charAt(i));
		}
		
		System.out.println(sb);
		
	}
}
