package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj22863_원상복구large {
	static StringBuilder sb = new StringBuilder();
	static int n; //n:카드수
	static long k; //k:섞은 횟수
	static int[] s, d; //s:k번 섞은 후 카드 순서, d:카드섞는 방향
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Long.parseLong(st.nextToken());
		
		
		
		s = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		
		d = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<n+1; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt=0;
		for(int i=1; i<n+1; i++) {
			if(d[i] != i) cnt++;
		}

		k = cnt==0?k%n:k%cnt;
		int[] temp = new int[n+1];
		
		for(int i=0; i<(int)k; i++) {
			for(int j=1; j<n+1; j++) {
				temp[d[j]] = s[j];
			}
			for(int j=1; j<n+1; j++) {
				s[j] = temp[j];
			}
		}
		
		for(int i=1; i<n+1; i++) {
			System.out.print(s[i]+" ");
		}
	}
}
