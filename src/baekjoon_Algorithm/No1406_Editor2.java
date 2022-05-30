package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No1406_Editor2 {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static LinkedList<String> editor;
	static int currentCurser=0;
	
	static void edit_func(StringTokenizer st) throws IOException {
		String order = st.nextToken();
		if(order.equals("P")) {
			editor.add(currentCurser, st.nextToken());
			currentCurser++;
		}else if(order.equals("B")) {
			if(!(currentCurser == 0)) {
				editor.remove(currentCurser-1);
				currentCurser--;
			}
		}else if(order.equals("L")) {
			if(!(currentCurser == 0)) {
				currentCurser--;
			}
		}else if(order.equals("D")) {
			if(!(currentCurser == editor.size())) {
				currentCurser++;
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		
		String str = br.readLine();
		currentCurser = str.length();
		int n = Integer.parseInt(br.readLine());
		editor = new LinkedList<>();
		for(int i=0; i<str.length(); i++) {
			editor.add(String.valueOf(str.charAt(i)));
		}
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			edit_func(st);
		}

		Iterator<String> it= editor.iterator();
		while(it.hasNext()) {
			sb.append(it.next());
		}
		System.out.println(sb);
	}
}
