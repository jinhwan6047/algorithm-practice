package study;

import java.util.Arrays;
import java.util.HashMap;

public class MenuRenewal_Study {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		
		MenuRenewal_Study sol = new MenuRenewal_Study();
		String[] result = sol.solution(orders, course);
		
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}
	
	//1. 
	public String[] solution(String[] orders, int[] course) {
		HashMap<String, Integer> list = new HashMap<>();
		//1. orders의 배열내 각 메뉴조합을 오름차순으로 정렬
		for(int i=0; i<orders.length; i++) {
			char[] ch = orders[i].toCharArray();
			Arrays.sort(ch);
			orders[i] = String.valueOf(ch);			
		}
		//2. course에 해당하는 메뉴 조합의 수에 맞게 orders를 분해해 HashMap에 넣는다. key:메뉴 value:주문수
		for(int i=0; i<orders.length; i++) {
			for(int j=0; j<course[i]; j++) {
				
			}
		}
		//3. value값중 가장 큰 수를 찾아서 그수가 2이상일때 key를 answer에 저장
        String[] answer = {};
        return answer;
    }

}
