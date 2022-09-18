package kakao_blind_2022;

import java.util.HashMap;
import java.util.HashSet;

public class Pgms92334_신고결과받기 {
	public static void main(String[] args) {
		String[] id_list = {"con", "ryan"};
		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k = 3;
		
		Pgms92334_신고결과받기 sol = new Pgms92334_신고결과받기();
		sol.solution(id_list, report, k);
	}
	
	HashMap<String, HashSet<String>> reportList = new HashMap<String, HashSet<String>>();
	HashMap<String, Integer> idNo = new HashMap<String, Integer>();
	
	public int[] solution(String[] id_list, String[] report, int k) {
		
        for(int i=0; i<report.length; i++) {
        	String[] str = report[i].split(" ");
        	
        	HashSet<String> tmpList = reportList.getOrDefault(str[1], new HashSet<String>());
        	tmpList.add(str[0]);
        	reportList.put(str[1], tmpList);
        }
        
        int[] answer = new int[id_list.length];
        
        for(int i=0; i<id_list.length; i++) {
        	String str = id_list[i];
			idNo.put(str, i);
        }
        
        for(int i=0; i<id_list.length; i++) {
			
			HashSet<String> reporter = reportList.get(id_list[i]);
			if(reporter != null && reporter.size()>=k) {
				for(String str : reporter) {
					answer[idNo.get(str)]++;
				}
			}
        }
        
        return answer;
    }
	
}
