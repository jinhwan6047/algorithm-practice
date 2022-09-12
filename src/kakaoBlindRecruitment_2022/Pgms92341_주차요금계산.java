package kakaoBlindRecruitment_2022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Pgms92341_주차요금계산 {
	public static void main(String[] args) {
		int[] fees = {120, 0, 60, 591};
		String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
		
		Pgms92341_주차요금계산 sol = new Pgms92341_주차요금계산();
		sol.solution(fees, records);
	}
	
	HashMap<Integer, String> parkingHst = new HashMap<Integer, String>();
	HashMap<Integer, Integer> timeList = new HashMap<Integer, Integer>();
	HashSet<Integer> ParKingList = new HashSet<Integer>();
	ArrayList<Integer> carNo = new ArrayList<Integer>(); 
	
	public int[] solution(int[] fees, String[] records) {
		
		for(int i=0; i<records.length; i++) {
			String[] str = records[i].split(" ");
			String time = str[0];
			int no = Integer.parseInt(str[1]);
			String sta = str[2];
			
			if(sta.equals("IN")) {
				parkingHst.put(no, time);
				ParKingList.add(no);
				if(!carNo.contains(no)) carNo.add(no);
			}else if(sta.equals("OUT")) {
				String[] tmpTime = parkingHst.get(no).split(":");
				int inTime = Integer.parseInt(tmpTime[0])*60+Integer.parseInt(tmpTime[1]);
				tmpTime = str[0].split(":");
				int outTime = Integer.parseInt(tmpTime[0])*60+Integer.parseInt(tmpTime[1]);
				
				int num = timeList.getOrDefault(no, 0)+outTime-inTime;
				timeList.put(no, num);
				
				ParKingList.remove(no);
			}	
		}
		
		for(int no : ParKingList) {
			String[] tmpTime = parkingHst.get(no).split(":");
			int inTime = Integer.parseInt(tmpTime[0])*60+Integer.parseInt(tmpTime[1]);
			int outTime = 23*60+59;
			
			int num = timeList.getOrDefault(no, 0)+outTime-inTime;
			timeList.put(no, num);
		}
		
		Collections.sort(carNo);
		int[] answer = new int[carNo.size()];
		
		for(int i=0; i<carNo.size(); i++) {
			int totalTime = timeList.get(carNo.get(i));
			if(totalTime<=fees[0]) {
				answer[i] = fees[1];
			}else {
				answer[i] = fees[1]+(((totalTime-fees[0])/fees[2]+((totalTime-fees[0])%fees[2]==0?0:1))*fees[3]);
			}
		}
		
		for(int num : answer) {
			System.out.println(num);
		}
		
		return answer;
	}
}
