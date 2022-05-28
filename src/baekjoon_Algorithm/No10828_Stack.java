package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No10828_Stack {
	static ArrayList<String> stack = new ArrayList<String>();
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(br.readLine());
		StringTokenizer order;
		
		for(int i=0; i<n; i++) {
			order = new StringTokenizer(br.readLine(), " ");
			func_stack(order);
		}
		
		System.out.println(sb);

	}

	static void func_stack(StringTokenizer order) {
		// TODO Auto-generated method stub
		String str = order.nextToken();
		if(str.equals("push")) {
			stack.add(order.nextToken());
		}else if(str.equals("pop")) {
			if(stack.size()==0) {
				sb.append("-1").append("\n");
			}else {
				sb.append(stack.remove(stack.size()-1)).append("\n");
			}
		}else if(str.equals("size")) {
			sb.append(Integer.toString(stack.size())).append("\n");
		}else if(str.equals("empty")) {
			if(stack.size()==0) {
				sb.append("1").append("\n");
			}else {
				sb.append("0").append("\n");
			}
		}else if(str.equals("top")) {
			if(stack.size()==0) {
				sb.append("-1").append("\n");
			}else {
				sb.append(stack.get(stack.size()-1)).append("\n");
			}
		}
	}

}
