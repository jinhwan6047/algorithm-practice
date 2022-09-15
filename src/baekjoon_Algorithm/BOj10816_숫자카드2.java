package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOj10816_숫자카드2 {
	static StringBuilder sb = new StringBuilder();
	static int[] arr, chk;
	static int n,m;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		m = Integer.parseInt(br.readLine());
		chk = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			int key =Integer.parseInt(st.nextToken());
			int lbound = lowBound(key);
			int hbound = highBound(key);
			chk[i] = hbound - lbound;
		}
		
		for(int num:chk)sb.append(num+" ");

		System.out.println(sb);
	}

	private static int highBound(int key) {
		int low = 0;
		int high = arr.length;
		int mid;
		
		while(low<high) {
			mid = (low+high)/2;
			
			if(key<arr[mid]) {
				high = mid;
			}else {
				low = mid+1;
			}
		}
		
		return low;
	}

	private static int lowBound(int key) {
		int low = 0;
		int high = arr.length;
		int mid;
		
		while(low<high) {
			mid = (low+high)/2;
			
			if(key<=arr[mid]) {
				high = mid;
			}else {
				low = mid+1;
			}
		}
		
		return low;
	}
}
