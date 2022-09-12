package pgms;

import java.util.ArrayList;

public class SkilChk_Lv1_02 {
	public static void main(String[] args) {
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		
		SkilChk_Lv1_02 sol = new SkilChk_Lv1_02();
		sol.solution(lottos, win_nums);
	}
	public int[] solution(int[] lottos, int[] win_nums) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		int zeroCnt=0;
		for(int num : lottos) {
			if(num !=0) {
				numbers.add(num);
			}else {
				zeroCnt++;
			}
		}
		int matchCnt=0;
		for(int num : win_nums) {
			if(numbers.contains(num))
				matchCnt++;
		}
		
        int[] answer = {(7-matchCnt-zeroCnt)!=7?(7-matchCnt-zeroCnt):6,(7-matchCnt)!=7?(7-matchCnt):6};
      
        return answer;
    }
}
