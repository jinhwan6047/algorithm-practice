package study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Marathon {

	public static void main(String[] args) {
		String[] part = {"leo", "kiki", "eden"};
		String[] comp = {"leo", "kiki"};
		Marathon sol = new Marathon();
		System.out.println(sol.solution1(part,comp));
		System.out.println(sol.solution2(part,comp));
		System.out.println(sol.solution3(part,comp));
	}
	
	//1. sorting으로 문제 해결
	public String solution1(String[] participant, String[] completion) {
		//1. 배열을 sorting
		Arrays.sort(participant);
		Arrays.sort(completion);
		//2. sorting한 배열을 비교
		int i=0;
		for(; i<completion.length; i++) {
			if(!participant[i].equals(completion[i])) {
				break;
			}
		}
		//3. 비교한 배열에서 값이 없을때는 마지막 사람이 답
		return participant[i];
	}
	
	//2. HashMap, keySet 사용
	public String solution2(String[] participant, String[] completion) {
		String answer="";
		//1. hashmap에 participant 담기
		HashMap<String, Integer> map = new HashMap<>();
		for(String player : participant) {
			map.put(player, map.getOrDefault(player, 0)+1);
		}
		//2. completion 빼기
		for(String player : completion) {
			map.put(player, map.get(player)-1);
		}
		//3. 나은 사람 출력
		for(String key : map.keySet()) {
			if(map.get(key) !=0 ) {
				answer = key;
			}
		}
		return answer;
	}

	//3. HashMap, entrySet 사용
	public String solution3(String[] participant, String[] completion) {
		String answer = "";
		//1.HashMap에 대상 배열 담기 (participant)
		HashMap<String, Integer> map = new HashMap<>();
		for(String player : participant) {
			map.put(player, map.getOrDefault(player, 0)+1);
		}
		//2. 대상배열을 비교대상배열과 비교(completion)
		for(String player : completion) {
			map.put(player, map.get(player)-1);
		}
		//3. entrySet 이용하여 결과 출력
		Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			if(entry.getValue() != 0) {
				answer = entry.getKey();
				break;
			}
		}
		return answer;
	}
}
