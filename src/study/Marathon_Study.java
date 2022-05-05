//https://programmers.co.kr/learn/courses/30/lessons/42576
//�����濡 ������ �������� �̸��� ��� �迭 participant�� ������ �������� �̸��� ��� �迭 completion�� �־��� ��, 
//�������� ���� ������ �̸��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
package study;

import java.util.*;

public class Marathon_Study {

	public static void main(String[] args) {
		String[] part = {"leo", "kiki", "eden"};
		String[] comp = {"leo", "kiki"};
		Marathon_Study sol = new Marathon_Study();
		//System.out.println(sol.solution1(part,comp));
		//System.out.println(sol.solution2(part,comp));
		System.out.println(sol.solution3(part,comp));
	}
	

	
	public String solution1(String[] participant, String[] completion) {
        //1. participant, completion 배열 정렬
		Arrays.sort(participant);
		Arrays.sort(completion);
		//2. 정렬된 배열을 1:1 비교
		for(int i=0; i<completion.length; i++) {
			if(!participant[i].equals(completion[i])) {
				//3. 배열 비교시 차이점 발생했을때의 participant항목이 정답
				return participant[i];
			}
		}
		//4. 예외처리 : 1:1 비교했을때까지 차이가 없었다면 participant의 배열 마지막이 정답
		return participant[participant.length-1];
	}
	
	public String solution2(String[] participant, String[] completion) {
		//1. participant를 HashMap에 넣어준다 key:이름, value:인원수 
		HashMap<String, Integer> list = new HashMap<>();
		for(String player : participant) {
			list.put(player, list.getOrDefault(player, 0)+1);
		}
		//2. completion의 항목을 participant의 HashMap에 key값으로 찾아 매칭시 인원수 -1 처리
		for(String player : completion) {
			list.put(player, list.get(player)-1);
		}
		//3. participant의 key중 value가 1이상인 키값을 return 한다
		String answer = "";
		for(String key : list.keySet()) {
			if(list.get(key) != 0) {
				answer = key;
				break; // 정답을 찾으면 반복문 탈출
			}
		}
		return answer;
	}
	
	public String solution3(String[] participant, String[] completion) {
		//1. participant를 HashMap에 넣어준다 key:이름, value:인원수
		HashMap<String, Integer> list = new HashMap<>();
		for(String player : participant) {
			list.put(player, list.getOrDefault(player, 0)+1);
		}
		//2. completion의 항목을 participant의 HashMap에 key값으로 찾아 매칭시 인원수 -1 처리
		for(String player : completion) {
			list.put(player, list.get(player)-1);
		}
		//3. participant의 key중 value가 1이상인 키값을 return 한다
		// 1) Iterator 형태로 HashMap을 entrySet()를 사용하여 Map.Entry로 변환한다
		// 2) while(hasNext())를 사용하여 value값이 1이상인 key를 찾는다		
		String answer ="";
		Iterator<Map.Entry<String, Integer>> it = list.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			if(entry.getValue() != 0) {
				answer = entry.getKey();
				break; // 정답을 찾으면 반복문 탈출
			}
		}
		
		return answer;
	}
}
