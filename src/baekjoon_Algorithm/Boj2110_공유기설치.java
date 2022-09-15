package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2110_공유기설치 {
	static StringBuilder sb = new StringBuilder();
	static int n,c;
	static long[] x;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		x = new long[n];
		
		for(int i=0; i<n; i++) {
			x[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(x);
		
		search();
		
	}

	public static void search() {
		long low = x[0];
		long high = x[n-1];
		
		long first = x[0];
		int cur=0;
		
		while(low<high) {
			long mid = (low+high)/2;
			
			int cnt=0;
			for(int i=cur; i<n; i++) {
				if(x[cur]-x[i]<=mid) {
					cnt++;
					cur = i;
				}
			}
			
			if(c<=cnt) {
				high = mid;
			}else {
				low = mid+1;
			}
			
		}
		
		System.out.println(low);
	}
}
