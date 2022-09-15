package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2805_나무자르기 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static long[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		
		arr = new long[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		long result = search();
		System.out.println(result);
		
	}

	private static long search() {
		long low = 0;
		long high = arr[n-1]+1;
		
		while(low<high) {
			long mid = (low+high)/2;
			long cnt=0;
			for(int i=0; i<n; i++) {
				cnt += (arr[i]-mid)>0?arr[i]-mid:0;
			}
			
			if(cnt<m) {
				high = mid;
			}else {
				low = mid+1;
			}
		}
		
		return low-1;
	}
}
