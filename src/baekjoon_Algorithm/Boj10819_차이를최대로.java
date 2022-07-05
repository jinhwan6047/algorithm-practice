package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10819_차이를최대로 {
	static StringBuilder sb = new StringBuilder();
	static int n, maxNum;
	static int[] arr, temp;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		temp = new int[n];
		visit = new boolean[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sumNum(0);
		
		System.out.println(maxNum);
	}
	
	static void sumNum(int depth) {
		if(depth == n) {
			checkSum(temp);
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(visit[i]) {
				continue;
			}
			visit[i] = true;
			temp[depth] = arr[i];
			sumNum(depth+1);
			visit[i] = false;
		}
	}

	private static void checkSum(int[] tempArr) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=0; i<n-1; i++) {
			sum += Math.abs(temp[i]-temp[i+1]);
		}
	
		maxNum = Math.max(maxNum, sum);
	}
}
