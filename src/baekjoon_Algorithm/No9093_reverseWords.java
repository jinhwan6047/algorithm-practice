package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No9093_reverseWords {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(br.readLine());
		StringTokenizer str;
		
		for(int i=0; i<n; i++) {
			str = new StringTokenizer(br.readLine(), " ");
			while(str.hasMoreElements()) {
				StringBuilder temp = new StringBuilder();
				temp.append(str.nextToken()).reverse().append(" ");
				sb.append(temp);
			}
			sb.append("\n");
			
		}
		
		System.out.println(sb);
	}

}
