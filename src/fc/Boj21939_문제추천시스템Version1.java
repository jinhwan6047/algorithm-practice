package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Boj21939_문제추천시스템Version1 {
	static StringBuilder sb = new StringBuilder();
	static int n,m;
	static TreeSet<Problem> list; // 문제 리스트
	static int[] problem; //문제 : 난이도
	static StringTokenizer st;
	
	public static class Problem implements Comparable<Problem>{
		int p;
		int l;
		public Problem(int p, int l) {
			super();
			this.l = l;
			this.p = p;
		}
		@Override
		public int compareTo(Problem o) {
			// TODO Auto-generated method stub
			if(this.l==o.l)return this.p-o.p;
			return this.l-o.l;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
	
		problem = new int[100001];
		list = new TreeSet<>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int p =Integer.parseInt(st.nextToken());
			int l =Integer.parseInt(st.nextToken());
			
			problem[p]= l;
			list.add(new Problem(p, l));
		}
		
		m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String command = st.nextToken();
			if(command.equals("add")) {
				add();
			}else if(command.equals("recommend")) {
				recommend();
			}else if(command.equals("solved")) {
				solved();
			}
		}
		System.out.println(sb);
	}
	
	private static void solved() {
		int p = Integer.parseInt(st.nextToken());
		int l = problem[p];
		
		list.remove(new Problem(p, l));
	}
	
	public static void recommend() {
		int x = Integer.parseInt(st.nextToken());
		if(x>0) {
			
			sb.append(list.last().p).append("\n");
		}else {
			
			sb.append(list.first().p).append("\n");
		}		
	}
	
	public static void add() {
		int p = Integer.parseInt(st.nextToken()); //문제번호
		int l = Integer.parseInt(st.nextToken()); //난이도
		
		problem[p]= l;
		list.add(new Problem(p, l));		
	}
}