//https://programmers.co.kr/learn/courses/30/lessons/42578
package study;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Comouflage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		Comouflage sol = new Comouflage();
		
		System.out.println(sol.solution(clothes));
	}
	//Hash를 활용한 solution
	// 1) 종류별로 분류 : 여러옷을 종류별로 분류한다
	// 2) 입지않는 경우 추가 : 종류별로 하나씩 입지 않아도 되니, 입지 않는 경우 추가
	// 3) 정체조합 : 전체 조합을 계산하고, 아무것도 입지 않는 경우를 빼준다
	public int solution(String[][] clothes) {
        
		//1. 옷을 종류별로 구분한다. 입지 않을 경우도 포합한다
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String[] clothe : clothes) {
			String type = clothe[1];
			map.put(type, map.getOrDefault(type, 1)+1);
		}
		//2. 모든조합을 계산한다
		Iterator<Integer> it = map.values().iterator();
		
		int answer = 1;
		while(it.hasNext()) {
			answer *= it.next().intValue();
		}
		
		//3. 아무종류의 옷도 입지 않는 경우 제외한다		
        return answer-1;
    }

}
