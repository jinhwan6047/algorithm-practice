package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj22945_팀빌딩 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] x;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		x = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) {
			x[i] = Integer.parseInt(st.nextToken());
		}
		
		search();
		
		System.out.println(result);
	}

	private static void search() {
		int s = 0;
		int e = n-1;
		
		while(s != e) {
			result = Math.max(result, (e-s-1)*Math.min(x[s], x[e]));
			if(x[s]>x[e]) {
				e--;
			}else {
				s++;
			}
		}
		
	}
}
