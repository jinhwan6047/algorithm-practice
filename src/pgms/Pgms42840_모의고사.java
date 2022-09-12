package pgms;

import java.util.ArrayList;

public class Pgms42840_모의고사 {
	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		
		Pgms42840_모의고사 sol = new Pgms42840_모의고사();
		sol.solution(answers);
	}
	public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5,};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int oneCnt=0; 
        int twoCnt=0; 
        int threeCnt=0;
        
        for(int i=0; i<answers.length; i++) {
        	int num = answers[i];
        	int oneIdx = (i%one.length);
        	int twoIdx = (i%two.length);
        	int threeIdx = (i%three.length);
        	if(one[oneIdx] == num)
        		oneCnt++;
        	if(two[twoIdx] == num)
        		twoCnt++;
        	if(three[threeIdx] == num)
        		threeCnt++;
        }
        
        int maxNum = Math.max(Math.max(oneCnt, twoCnt), threeCnt);
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(oneCnt == maxNum) 
        	list.add(1);     
        if(twoCnt == maxNum)
        	list.add(2);
        if(threeCnt == maxNum)
        	list.add(3);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}
