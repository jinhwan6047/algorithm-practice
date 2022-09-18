package kakao_intern_2022;

import java.util.HashMap;

public class Lv1_성격유형검사하기 {
	public static void main(String[] args) {
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		
		Lv1_성격유형검사하기 sol = new Lv1_성격유형검사하기();
		sol.solution(survey, choices);
	}
	
	HashMap<String, Integer> serv = new HashMap<String, Integer>();
	public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        serv.put("R", 0);
        serv.put("T", 0);
        serv.put("C", 0);
        serv.put("F", 0);
        serv.put("J", 0);
        serv.put("M", 0);
        serv.put("A", 0);
        serv.put("N", 0);
        
        for(int i=0; i<survey.length; i++) {
        	int num = choices[i];
        	String[] typ = survey[i].split("");
        	if(num>4) {
        		int tmp = serv.get(typ[1]);
        		tmp += (num-4);
        		serv.put(typ[1], tmp);
        	}else if(num<4) {
        		int tmp = serv.get(typ[0]);
        		tmp += (4-num);
        		serv.put(typ[0], tmp);
        	}
        }
        
        answer += serv.get("R")>=serv.get("T")?"R":"T";
        answer += serv.get("C")>=serv.get("F")?"C":"F";
        answer += serv.get("J")>=serv.get("M")?"J":"M";
        answer += serv.get("A")>=serv.get("N")?"A":"N";
        
        System.out.println(answer);
        return answer;
    }
}
