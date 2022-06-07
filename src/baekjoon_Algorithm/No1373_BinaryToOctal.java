package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No1373_BinaryToOctal {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str= br.readLine();
		Stack<Integer> stack = new Stack<>();
		
		String[] arr = str.split("");
		for(int i=0; i<arr.length; i++) {
			stack.push(Integer.parseInt(arr[i]));
		}
		
		int cnt=0;
		int temp=0;
		while(!stack.isEmpty()) {
			temp += stack.pop()*(int)Math.pow(10, cnt);
			cnt++;		
			if(cnt == 3 || stack.isEmpty()) {
				sb.insert(0, Integer.parseInt(String.valueOf(temp), 2));
				cnt=0;
				temp=0;
			}
		}
		System.out.println(sb);
	}
}
