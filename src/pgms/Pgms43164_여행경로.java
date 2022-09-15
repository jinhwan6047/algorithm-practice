package pgms;

import java.util.ArrayList;
import java.util.Collections;

public class Pgms43164_여행경로 {
	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		
		Pgms43164_여행경로 sol = new Pgms43164_여행경로();
		sol.solution(tickets);
	}
	String[][] tickets;
	boolean[] visit;
	int n;
	ArrayList<String> result = new ArrayList<String>();
	
	public String[] solution(String[][] tickets) {
		
		this.tickets = tickets;
		this.n = tickets.length;
		
		for(int i=0; i<n; i++) {
			this.visit = new boolean[tickets.length];
			String s = tickets[i][0];
			String e = tickets[i][1];
			
			if(s.equals("ICN")) {
				visit[i] = true;
				search(i,1,tickets[i][0]+tickets[i][1]);							
			}
		}
		Collections.sort(result);
		String str = result.get(0);
		int num = str.length()/3;		
		String[] answer = new String[num];
		
		
		for(int i=0; i<num; i++) {
			answer[i] = str.substring(i*3, i*3+3);
		}
		return answer;
	}

	private void search(int idx, int cnt, String str) {
		if(cnt==n) {
			if(!result.contains(str)) {
				result.add(str);				
			}
			return;
		}
		String cs = tickets[idx][0];
		String ce = tickets[idx][1];
		
		for(int i=0; i<n; i++) {
			if(i != idx && !visit[i] && ce.equals(tickets[i][0])) {
				visit[i] = true;
				search(i, cnt+1, str+tickets[i][1]);
				visit[i] = false;
			}
		}
	}
}
