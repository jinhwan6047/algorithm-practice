package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No10845_Queue {
	static ArrayList<Integer> queue = new ArrayList<Integer>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		 
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			queue_func(st);
		}
		
		System.out.println(sb);
		
	}

	static void queue_func(StringTokenizer st) {
		// TODO Auto-generated method stub
		String order = st.nextToken();
		switch (order) {
		case "push":
			queue.add(Integer.parseInt(st.nextToken()));
			break;
		case "pop":
			if(!queue.isEmpty()) {
				sb.append(queue.remove(0)).append("\n");
			}else {
				sb.append(-1).append("\n");
			}
			break;
		case "size":
			sb.append(queue.size()).append("\n");
			break;
		case "empty":
			if(!queue.isEmpty()) {
				sb.append(0).append("\n");
			}else {
				sb.append(1).append("\n");
			}
			break;
		case "front":
			if(!queue.isEmpty()) {
				sb.append(queue.get(0)).append("\n");
			}else {
				sb.append(-1).append("\n");
			}
			break;
		case "back":
			if(!queue.isEmpty()) {
				sb.append(queue.get(queue.size()-1)).append("\n");
			}else {
				sb.append(-1).append("\n");
			}
			break;
		}
	}


}
