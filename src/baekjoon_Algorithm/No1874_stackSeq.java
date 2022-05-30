package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No1874_stackSeq {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list = new ArrayList<>();
	static ArrayList<Integer> stack = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n =Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		if(chk_func(list)) {
			System.out.println(sb);
		}else {
			System.out.println("NO");
		}
	}

	static boolean chk_func(ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		int cnt=0;
		while(!list.isEmpty()) {
			if(stack.isEmpty()) {
				for(int i=cnt; i<list.get(0); i++) {
					sb.append("+").append("\n");
					stack.add(i+1);
					cnt++;
				}
			}
			if(stack.get(stack.size()-1) == list.get(0)) {
				sb.append("-").append("\n");
				stack.remove(stack.size()-1);
				list.remove(0);
			}else if(stack.get(stack.size()-1) > list.get(0)) {
				return false;
			}else if(stack.get(stack.size()-1) < list.get(0)) {
				for(int i=cnt; i<list.get(0); i++) {
					sb.append("+").append("\n");
					stack.add(i+1);
					cnt++;
				}
			}
		}
		return true;
	}
}
