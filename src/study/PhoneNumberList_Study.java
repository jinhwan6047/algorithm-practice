package study;

import java.util.*;

public class PhoneNumberList_Study {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] phone_book = {"12","123","1235","567","88"};
		
		PhoneNumberList_Study sol = new PhoneNumberList_Study();
		System.out.println(sol.solution1(phone_book));
		System.out.println(sol.solution2(phone_book));
	}
	
	public boolean solution1(String[] phone_book) {
        boolean answer = true;
        //1. phone_book배열을 오름차순 정렬
        Arrays.sort(phone_book);
        //2. 정렬한 배열을 앞뒤 비교하여 접두어가 있는지 확인
        for(int i=0; i<phone_book.length-1; i++) {
        	//3. 접두어가 있으면 false, 없으면 true 반환
        	if(phone_book[i+1].startsWith(phone_book[i])) {
        		answer = false;
        		break;
        	}
        }
        
        return answer;
    }

	public boolean solution2(String[] phone_book) {
		boolean answer = true;
		//1. phone_book을 HashMap에 넣는다
		HashMap<String, Integer> list = new HashMap<>();
		for(String phone : phone_book) {
			list.put(phone, 1);
		}
		//2. HashMap에 접두어가 있는지 확인
		Iterator<String> it = list.keySet().iterator();
		while(it.hasNext()) {
			String phone = it.next();
			for(int i=0; i<phone.length()-1;i++) {
				//3. 접두어가 있으면 false, 없으면 true 반환
				if(list.containsKey(phone.substring(0, i+1))) {
					return false;
				}
			}
		}
        return answer;
	}
}
