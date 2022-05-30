package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class No1406_Editor {
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    LinkedList<Character> editor = new LinkedList<Character>();
	    
	    String str = br.readLine();
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<str.length(); i++) {
			editor.add(str.charAt(i));
		}
		
		ListIterator<Character> it = editor.listIterator();
		while(it.hasNext()) {
			it.next();
		}
		
		for(int i=0; i<n; i++) {
			String order = br.readLine();
		    switch (order.charAt(0)) {
		    case 'P':
			   it.add(order.charAt(2));
			   break;
		    case 'B':
		    	if(it.hasPrevious()) {
					it.previous();
					it.remove();
				}
			    break;
		    case 'L':
		    	if(it.hasPrevious())
					it.previous();
			    break;
		    case 'D':
		    	if(it.hasNext())
					it.next();
			    break;
		    }
		}

		for(Character chr : editor) {
			bw.write(chr);
		}
		bw.flush();
	}
}
