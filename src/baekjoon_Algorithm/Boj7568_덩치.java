package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj7568_덩치 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static ArrayList<Member> list = new ArrayList<>();
	static int[] result;
	
	public static class Member {
		int w;
		int h;
		public Member(int w, int h) {
			super();
			this.w = w;
			this.h = h;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		result = new int[n];
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			list.add(new Member(w,h));
		}
		
		search();
		
		for(int num : result) {
			System.out.print((num+1) + " ");
		}
	}

	private static void search() {
		for(int i=0; i<n-1; i++) {
			Member m1 = list.get(i);
			for(int j=i+1; j<n; j++) {
				Member m2 = list.get(j);
				if(m1.h>m2.h && m1.w>m2.w) {
					result[j]++;
				}else if(m1.h<m2.h && m1.w<m2.w) {
					result[i]++;
				}
			}
		}
		
	}
}
