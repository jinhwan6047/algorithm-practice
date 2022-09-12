package pgms;

import java.util.ArrayList;

public class Pgms12973_짝지어제거하기 {
	public static void main(String[] args) {
		String s = "cdcd";
		
		Pgms12973_짝지어제거하기 sol = new Pgms12973_짝지어제거하기();
		sol.solution(s);
	}
	public int solution(String s){
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(!list.isEmpty() && list.get(list.size()-1) == ch) {
				list.remove(list.size()-1);
			}else {
				list.add(ch);
			}
		}
		
		if(list.isEmpty()) {
			return 1;
		}
		return 0;
    }
}
