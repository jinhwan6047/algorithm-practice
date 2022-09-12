package pgms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Pgms42578_위장 {
	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		
		Pgms42578_위장 sol = new Pgms42578_위장();
		System.out.println(sol.solution(clothes));
	}
	public int solution(String[][] clothes) {
		HashMap<String, Integer> wear = new HashMap<String, Integer>();
		for(int i=0; i<clothes.length; i++) {
			wear.put(clothes[i][1], wear.getOrDefault(clothes[i][1], 1)+1);
		}
		
		int answer = 1;
		Iterator<Map.Entry<String, Integer>> it = wear.entrySet().iterator();
		while(it.hasNext()) {
			int num = it.next().getValue();
			answer *= num;
		}
		
        return answer-1;
    }
}
