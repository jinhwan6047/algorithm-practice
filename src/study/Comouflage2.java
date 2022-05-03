package study;

import java.util.HashMap;
import java.util.Iterator;

public class Comouflage2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		Comouflage sol = new Comouflage();
		
		System.out.println(sol.solution(clothes));
	}

	public int solution(String[][] clothes) {
		int answer = 1;
		//1. 옷의 종류별로 map에 입력, 입지않을 경우도 포함해서 입력
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String[] clothe : clothes) {
			String type = clothe[1];
			map.put(type, map.getOrDefault(type, 1)+1);
		}
		//2. 옷의 조합 경우의수 구하기
		Iterator<Integer> it = map.values().iterator();
		
		while(it.hasNext()) {
			answer *= it.next().intValue();
		}
		//3. 예외처리 : 옷을 입지 않을 경우
		return answer-1;
	}
}
