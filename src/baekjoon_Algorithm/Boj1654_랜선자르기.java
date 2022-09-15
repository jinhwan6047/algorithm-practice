package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1654_랜선자르기 {
	static StringBuilder sb = new StringBuilder();
	static int n, k;
	static long[] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr = new long[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		long result = BinarySearch();
		System.out.println(result);
	}

	private static long BinarySearch() {
		long low = 0;
		long high = arr[n-1]+1;
		
		while(low<high) {
			long mid = (low+high)/2;
			long cnt=0;
			for(int i=0; i<n; i++) {
				cnt+=arr[i]/mid;
			}
			
			if(cnt<k) {
				high = mid;
			}else {
				low=mid+1;
			}
		}
		return low-1;
	}
	
}
