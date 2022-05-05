package study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class ReportResult_Study {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] id_list = {"con", "ryan"};
		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k= 3;
		
		ReportResult_Study sol = new ReportResult_Study();
		int[] result = sol.solution(id_list, report, k);
		
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]);
		}
	}

	public int[] solution(String[] id_list, String[] report, int k) {
		//0. 동일한 신고는 중복 제거
		HashSet<String> hashReport = new HashSet<>();
		for(String hr : report) {
			hashReport.add(hr);
		}
		//1. key:신고당한사람, value:신고자리스트 로 HashMap을 만든다
		HashMap<String, ArrayList<String>> list = new HashMap<>();
		for(String rep : hashReport) {
			String reporter = rep.split(" ")[0];
			String reportee = rep.split(" ")[1];
			
			ArrayList<String> repList = list.getOrDefault(reportee, null);
			if(repList == null) {
				repList = new ArrayList<>();
			}
			repList.add(reporter);
			list.put(reportee, repList);
		}
		//2. key가 id_list인 HashMap을 만든다
		HashMap<String, Integer> reportCount = new HashMap<>();
		for(String id : id_list) {
			reportCount.put(id, 0);
		}
		
		//3. list HashMap중 value의 크기가 2 이상인 Key를 찾아  value에 해당하는 key에 +1해준다 
		Iterator<Map.Entry<String, ArrayList<String>>> it = list.entrySet().iterator();
		
		while(it.hasNext()) {
			ArrayList<String> reporterList = it.next().getValue();
			if(reporterList.size()>= k) {
				for(String id : reporterList) {
					reportCount.put(id, reportCount.get(id)+1);
				}
			}
		}
		//4. reportCount의 value를 id_list의 순서에 맞게 answer에 담아준다
		int[] answer = new int[id_list.length];
		for(int i=0; i<id_list.length; i++) {
			if(reportCount.containsKey(id_list[i])) {
				answer[i] = reportCount.get(id_list[i]);
			}
		}
        return answer;
    }
}
