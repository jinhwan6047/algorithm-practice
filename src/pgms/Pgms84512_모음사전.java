package pgms;

import java.util.ArrayList;

public class Pgms84512_모음사전 {
	public static void main(String[] args) {
		String word = "I";
		
		Pgms84512_모음사전 sol = new Pgms84512_모음사전();
		sol.solution(word);
	}
	
	ArrayList<String> list = new ArrayList<String>();
	String end;
	
	public int solution(String word) {
		int answer = 0;
		String[] strArr = {"A","E","I","O","U"};
		end = word;
		
		search("", 0, strArr);
		
		
		return list.indexOf(end);
	}

	public void search(String str, int cnt, String[] strArr) {
		if(cnt>5) return;
		
		if(!list.contains(str)) list.add(str);
		if(str.equals(end)) return;
		
		for(int i=0; i<5; i++) {
			search(str+strArr[i], cnt+1, strArr);
		}
		
	}
}
