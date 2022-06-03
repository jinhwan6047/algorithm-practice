package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No17298_NGE {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<n; i++) {
			while(!stack.isEmpty() && arr[stack.peek()]<arr[i]) {
				arr[stack.pop()] = arr[i]; 
			}
			stack.push(i);			
		}
		while(!stack.isEmpty()) {
			arr[stack.pop()]=-1;
		}
		
		for(int i=0; i<n; i++) {
			sb.append(arr[i]).append(" ");			
		}
		
		System.out.println(sb);
	}
}
