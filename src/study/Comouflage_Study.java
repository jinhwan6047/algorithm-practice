package study;

import java.util.HashMap;
import java.util.Iterator;

public class Comouflage_Study {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		Comouflage_Study sol = new Comouflage_Study();
		
		System.out.println(sol.solution(clothes));
	}
	
	public int solution(String[][] clothes) {
		//1.clothes를 HashMap에 넣는다. key:종류 value:가지수 , 종류별 안입는 경우의 수도 추가
		HashMap<String, Integer> list = new HashMap<>();
		for(int i=0; i<clothes.length; i++) {
			list.put(clothes[i][1], list.getOrDefault(clothes[i][1], 1)+1);
		}

		//2.종류별 경우의 수를 계산
		Iterator<Integer> it = list.values().iterator();
		
		int answer = 1;
		while(it.hasNext()) {
			answer *= it.next(); 
		}
		//3. 모두안입는 경우의 수 제외
        return answer-1;
    }

}
