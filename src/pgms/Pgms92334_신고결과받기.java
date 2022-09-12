package pgms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Pgms92334_신고결과받기 {
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k =2;
		
		Pgms92334_신고결과받기 sol = new Pgms92334_신고결과받기();
		sol.solution(id_list, report, k);
	}
	public int[] solution(String[] id_list, String[] report, int k) {
		//신고리스트 -> 신고당한사람 : 신고자 
		HashMap<String, HashSet<String>> reportMap = new HashMap<>();
		//회원 -> 아이디 : 처리결과메일 횟수
		HashMap<String, Integer> member = new HashMap<>();
		for(String str : id_list) {
			member.put(str, 0);
		}	
		
		for(String str : report) {
			String reporter = str.split(" ")[0];
			String reportee = str.split(" ")[1];
			
			HashSet<String> temp = reportMap.getOrDefault(reportee, new HashSet<String>());	
			temp.add(reporter);
			reportMap.put(reportee, temp);
		}

		Iterator<Map.Entry<String, HashSet<String>>> it = reportMap.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, HashSet<String>> temp = it.next();
			HashSet<String> tempList = temp.getValue();
			if(tempList.size()>=k) {
				for(String str : tempList) {
					member.put(str, member.get(str)+1);
				}
			}
		}
				
		int[] answer = new int[id_list.length];
		for(int i=0; i<id_list.length; i++) {
			answer[i] = member.get(id_list[i]);
		}
        
        return answer;
    }
}
