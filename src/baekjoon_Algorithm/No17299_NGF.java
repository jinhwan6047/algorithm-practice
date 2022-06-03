package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No17299_NGF {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] list = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] arr = new int[1000000];
		
		for(int i=0; i<n; i++) {
			arr[list[i]-1]++;
		}
		
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<n; i++) {
			while(!stack.isEmpty() && arr[list[i]-1]>arr[list[stack.peek()]-1]) {
				list[stack.pop()] = list[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			list[stack.pop()] = -1;
		}
		
		for(int i=0; i<n; i++) {
			sb.append(list[i]).append(" ");
		}
		
		System.out.println(sb);
	}
	
}
