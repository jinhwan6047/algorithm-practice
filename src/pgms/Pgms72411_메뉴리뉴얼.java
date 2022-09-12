package pgms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Pgms72411_메뉴리뉴얼 {
	public static void main(String[] args) {
		String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course = {2,3,5};
		
		Pgms72411_메뉴리뉴얼 sol = new Pgms72411_메뉴리뉴얼();
		sol.solution(orders, course);
	}
	HashMap<String, Integer> menu;
	ArrayList<String> menuList = new ArrayList<String>();
	
    public String[] solution(String[] orders, int[] course) {
    	
    	for(int i=0; i<orders.length; i++) {
    		String str = orders[i];
    		char[] ch = str.toCharArray();
    		Arrays.sort(ch);
    		orders[i] = new String(ch);
    	}
    	
    	for(int i=0; i<course.length; i++) {
    		menu = new HashMap<String, Integer>();
    		
    		for(int j=0; j<orders.length; j++) {
    			combination("",orders[j], course[i]);
    		}
    		
    		ArrayList<Integer> cntList = new ArrayList<Integer>(menu.values());
    		if(!cntList.isEmpty()) {
    			int max = Collections.max(cntList);
    			if(max>1) {
    				for(String k : menu.keySet()) {
    					if(menu.get(k) == max) {
    						menuList.add(k);
    					}
    				}			
    			}   			
    		}
    	}
    	
    	Collections.sort(menuList);
    	
    	String[] answer = new String[menuList.size()];
    	
    	for(int i=0; i<menuList.size(); i++) {
    		answer[i] = menuList.get(i);
    	}
    	
    	
        return answer;
    }
    
	public void combination(String combiStr, String order, int cnt) {
		if(combiStr.length() == cnt) {
			menu.put(combiStr, menu.getOrDefault(combiStr, 0)+1);
			return;
		}
		for(int i=0; i<order.length(); i++) {
			String tempCombiStr = combiStr+order.charAt(i);
			String tempOrder = order.substring(i+1);
			combination(tempCombiStr, tempOrder, cnt);
		}
	}
}
