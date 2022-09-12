package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2798_블랙잭 {
	static StringBuilder sb = new StringBuilder();
	static int n,m;
	static int[] card;
	static boolean[] visit;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		card = new int[n];
		visit = new boolean[n];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			if(card[i]>m) visit[i] = true;
		}
		
		search(0, 0);
		
		System.out.println(result);
	}

	private static void search(int sum, int cnt) {
		if(cnt == 3) {
			if(sum<=m) {
				result = Math.max(sum, result);
			}
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!visit[i] && card[i]<=m && sum<=m) {
				visit[i] = true;
				search(sum+card[i], cnt+1);
				visit[i] = false;
			}
		}
	}
}
