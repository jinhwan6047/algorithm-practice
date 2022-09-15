package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1300_K번째수 {
	static StringBuilder sb = new StringBuilder();
	static long n,k;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Long.parseLong(br.readLine());
		k = Long.parseLong(br.readLine());
		
		search();
		
	}

	public static void search() {
		Long low = 1L;
		Long high = k;
		
		while(low<high) {
			
			Long mid = (low+high)/2;
			Long cnt=0L;
			
			for(int i=1; i<=n; i++) {
				cnt += Math.min(mid/i, n);
			}
			if(k<=cnt) {
				high = mid;
			}else {
				low = mid+1;
			}
		}
		
		System.out.println(low);
	}

}
