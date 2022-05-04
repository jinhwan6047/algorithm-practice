package study;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRenewal {
	List<String> answerList = new ArrayList<>();
	Map<String, Integer> hashMap = new HashMap<>(); 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		
		MenuRenewal sol = new MenuRenewal();
		String[] result = sol.solution(orders, course);
		
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}

	 public String[] solution(String[] orders, int[] course) {
	        
		 //1. order 를 정렬
		 for(int i=0; i<orders.length; i++) {
			 char[] arr = orders[i].toCharArray();  //문자열은 정렬을 할수 없기 때문에 char형태로 변환하여 정렬 후 다시 orders에 삽입
			 Arrays.sort(arr);
			 orders[i] = String.valueOf(arr);
		 }
		 //2. 코스길이별 조합
		for(int courseLength : course) {
			for(String order : orders) {
				combination("", order, courseLength);
			}
			
			//3.가장 많은 조합 저장
			if(!hashMap.isEmpty()) {
				List<Integer> countList = new ArrayList<>(hashMap.values());
				int max = Collections.max(countList);
				
				if(max>1) {
					for(String key : hashMap.keySet()) {
						if(hashMap.get(key) == max) {
							answerList.add(key);
						}
					}
				}
				hashMap.clear();
			}
		}
		
		Collections.sort(answerList);
		String[] answer = new String[answerList.size()];
		for(int i=0; i<answer.length; i++) {
			answer[i] = answerList.get(i);
		}
	    return answer;	    
	 }
	 
	 public void combination(String order, String others, int count) {
		 //탈출조건
		 if(count == 0) {
			 hashMap.put(order, hashMap.getOrDefault(order, 0)+1);
			 return;
		 }
		 //수행동작:0부터 length까지 조합
		 for(int i=0; i<others.length(); i++) {
			 combination(order + others.charAt(i), others.substring(i+1), count -1);
		 }
	 }
}
