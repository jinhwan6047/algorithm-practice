package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No10866_Deque {
	static ArrayList<Integer> dq = new ArrayList<Integer>();
	static StringBuilder sb = new StringBuilder();

	static void deque_func(StringTokenizer st) {
		String order = st.nextToken();
		switch (order) {
		case "push_front":
			dq.add(0, Integer.parseInt(st.nextToken()));
			break;
		case "push_back":
			dq.add(Integer.parseInt(st.nextToken()));
			break;
		case "pop_front":
			if(dq.isEmpty()) {
				sb.append(-1).append("\n");
			}else {
				sb.append(dq.remove(0)).append("\n");
			}
			break;
		case "pop_back":
			if(dq.isEmpty()) {
				sb.append(-1).append("\n");
			}else {
				sb.append(dq.remove(dq.size()-1)).append("\n");
			}		
			break;
		case "size":
			sb.append(dq.size()).append("\n");
			break;
		case "empty":
			if(dq.isEmpty()) {
				sb.append(1).append("\n");
			}else {
				sb.append(0).append("\n");
			}
			break;
		case "front":
			if(dq.isEmpty()) {
				sb.append(-1).append("\n");
			}else {
				sb.append(dq.get(0)).append("\n");
			}
			break;
		case "back":
			if(dq.isEmpty()) {
				sb.append(-1).append("\n");
			}else {
				sb.append(dq.get(dq.size()-1)).append("\n");
			}
			break;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			deque_func(st);
		}
		System.out.println(sb);
	}
}
