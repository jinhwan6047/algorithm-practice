//https://programmers.co.kr/learn/courses/30/lessons/42576
//마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
//완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
package study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Marathon_who_did_not_complete {

	public static void main(String[] args) {
		String[] part = {"leo", "kiki", "eden"};
		String[] comp = {"leo", "kiki"};
		Marathon_who_did_not_complete sol = new Marathon_who_did_not_complete();
		System.out.println(sol.solution1(part,comp));
		System.out.println(sol.solution2(part,comp));
		System.out.println(sol.solution3(part,comp));
	}
	

	// Sorting/Loop를 사용하여 문제 해결법
	// 1) 두 list를 sorting
	// 2) completion list의 length만큼 1:1로 돌면서 participant에만 존재하는 한명을 찾는다
	// 3) list를 전부 다 뒤져도 답이 없다면 participant의 마지막 주자가 완주하지 못한것 
	public String solution1(String[] participant, String[] completion) {
        //1. 두 배열을 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        //2. 두 배열이 다를 때까지 찾는다
        int i=0;
        for(; i<completion.length; i++) {
        	if(!participant[i].equals(completion[i])) {
        		break;
        	}
        }
        
        //3. 여기까지 왔다면, 마지막 주자가 완주하지 못한것
        // 위 for문 돌면서  participant와 completion을 비교해 다른 i 값을 찾는다면 찾은 i번째 participant가 정답
        // for문을 다돌아도 다른것을 못찾았다면 마지막(for문이 끝날때 i번째) participant가 정답
        return participant[i];
    }
	
	
	// Hash를 활용한 문제 해결
	// 1) Hash만들기 : key에 순서 이름을, value의Count를 갖는 HashMap을 만든다
	// 2) Hash빼기 : completion에 존재하는 선수들의Hash를 뺀다
	// 3) 마지막 주자 : Value가 남아있는 선수가 완주하지 못한 선수이다
	public String solution2(String[] participant, String[] completion) {
		String answer ="";
		//1. Hash Map을 만든다 (participant)
		HashMap<String, Integer> map = new HashMap<>();
		for(String player : participant) {
			//동명이인이 있을수 있기 때문에 getOrDefalut를 사용함
			map.put(player, map.getOrDefault(player, 0) + 1);//이전에 같은 player가 없었다면 0으로, 있었다면 +1
		}
		
		//2. Hash Map을 뺀다(completion)
		for(String player : completion) {
			//completion에 잇는 명단은 participant에 포함되어있는것이 확실하기 때문에 getOrDefault를 사용하지 않아도 됨
			map.put(player, map.get(player) -1);
		}
		//3. value가 0이 아닌 마지막 주자를 찾는다.
		for(String key : map.keySet()) {
			if(map.get(key) != 0) {
				answer = key;
				break;
			}
		}
		
		return answer;
	}
	
	
	// Hash를 활용한 문제 해결2 - entrySet 이용
	// 1,2번 까지 Hash를 활용한 문제 해결1과 방식은 같고 3번에서 entrySet을이용
	// 반복문에서 entrySet이 성능이 더 좋음 하지만 keySet보다 어려움
	public String solution3(String[] participant, String[] completion) {
		String answer ="";
		//1. Hash Map을 만든다 (participant)
		HashMap<String, Integer> map = new HashMap<>();
		for(String player : participant) {
			//동명이인이 있을수 있기 때문에 getOrDefalut를 사용함
			map.put(player, map.getOrDefault(player, 0) + 1);//이전에 같은 player가 없었다면 0으로, 있었다면 +1
		}
		
		//2. Hash Map을 뺀다(completion)
		for(String player : completion) {
			//completion에 잇는 명단은 participant에 포함되어있는것이 확실하기 때문에 getOrDefault를 사용하지 않아도 됨
			map.put(player, map.get(player) -1);
		}
		//3. value가 0이 아닌 마지막 주자를 찾는다.
		Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator(); //Iterator는 반복문을 쉽게 해주는 class
		
		while(iter.hasNext()) {
			Map.Entry<String, Integer> entry = iter.next();
			if(entry.getValue() !=0) {
				answer = entry.getKey();
				break;
			}
		}
		return answer;
	}
}
