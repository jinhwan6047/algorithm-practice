package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10799_SplitStic {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int layer=0;
		boolean afterLayser = false;
		int result=0;
		
		StringTokenizer st = new StringTokenizer(str,"()",true);
		while(st.hasMoreTokens()) {
			if(st.nextToken().equals("(")) {
				layer++;
				afterLayser = false;
			}else {
				layer--;
				if(afterLayser) {
					result++;
				}else {
					result += layer;
					afterLayser = true;
				}
			}
		}
		
		System.out.println(result);
	}

}
