package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17413_ReverseWords2 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, "<>", true);
		
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			if(token.equals("<")) {
				sb.append("<").append(st.nextToken()).append(st.nextToken());
			}else {
				reverse_func(token);
			}
			
		}
		
		System.out.println(sb);
	}

	static void reverse_func(String str) {
		// TODO Auto-generated method stub
		StringTokenizer st;
		st = new StringTokenizer(str," ",true);
		
		while(st.hasMoreTokens()) {
			StringBuilder temp = new StringBuilder();
			temp.append(st.nextToken()).reverse();
			sb.append(temp);
		}
	}

}
