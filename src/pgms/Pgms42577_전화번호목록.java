package pgms;

import java.util.Arrays;

public class Pgms42577_전화번호목록 {
	public static void main(String[] args) {
		String[] numbers = {"9","11111","222"};
		
		Pgms42577_전화번호목록 sol = new Pgms42577_전화번호목록();
		System.out.println(sol.solution(numbers));
	}
	public boolean solution(String[] phone_book) {
		
		boolean answer = true;
		Arrays.sort(phone_book);
		for(int i=0; i<phone_book.length-1; i++) {
			if(phone_book[i+1].startsWith(phone_book[i])) {
				answer = false;
				break;
			}
		}  
        return answer;
    }
}
