package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No1406_Editor3 {
	static Stack<Character> lStack = new Stack<>();
	static Stack<Character> rStack = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int n = Integer.parseInt(br.readLine());
				
		for(int i=0;i<str.length();i++) {
			lStack.add(str.charAt(i));
		}
		
		for(int i=0; i<n; i++) {
			String order = br.readLine();
			editor_func(order);
		}
				
		while(!lStack.isEmpty()) {
			rStack.push(lStack.pop());
		}
		while(!rStack.isEmpty()) {
			sb.append(rStack.pop());
		}
		System.out.println(sb);
	}

	static void editor_func(String order) {
		// TODO Auto-generated method stub
		switch (order.charAt(0)) {
	    	case 'P':
	    		lStack.push(order.charAt(2));
	    		break;
	    	case 'B':
	    		if(!lStack.isEmpty()) {
	    			lStack.pop();	    			
	    		}
	    		break;
	    	case 'L':
	    		if(!lStack.isEmpty()) {
	    			rStack.push(lStack.pop());	    			
	    		}
	    		break;
	    	case 'D':
	    		if(!rStack.isEmpty()) {
	    			lStack.push(rStack.pop()); 			
	    		}
	    		break;
	    }
	}	
}
