package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No1158_Josephus {
	static StringBuilder sb = new StringBuilder();
	
	static void josephus(int n, int k, ArrayList<Integer> list) {
		
		int currentIndex=0;
		sb.append("<");
		while(n>1) {
			currentIndex = (currentIndex + (k - 1)) % list.size();;
			sb.append(list.remove(currentIndex)).append(", ");										
			n--;
		}
		
		sb.append(list.get(0)).append(">");
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		for(int i=0; i<n; i++) {
			list.add(i+1);
		}
		
		
		josephus(n, k, list);
		System.out.println(sb);
	}

}
