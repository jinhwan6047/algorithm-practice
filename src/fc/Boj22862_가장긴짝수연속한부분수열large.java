package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj22862_가장긴짝수연속한부분수열large {
	static int n,k;
	static int[] s;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		s = new int[n];

		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		
		
		
		int cnt=0;
		int max=0;
		
		for(int sIdx=0, eIdx=0; sIdx<n; sIdx++) {
			while(eIdx<n) {
				if(s[eIdx]%2==0) eIdx++;
				else {
					if(cnt == k) break;
					cnt++;
					eIdx++;
				}
			}
			max = Math.max(max, eIdx-sIdx-cnt);
			if(s[sIdx]%2==1) cnt--;
		}
		
		
		System.out.println(max);
	}
}
