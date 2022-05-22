package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto_77484 {
	
	public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int winCount=0;
        int zeroCount=0;
        ArrayList<Integer> winNums = new ArrayList<Integer>();
        for(Integer num : win_nums) {
        	winNums.add(num);
        }
        
        for(int i=0; i<lottos.length; i++) {
        	if(lottos[i] == 0) {
        		zeroCount++;
        	}else {
        		if(winNums.contains(lottos[i])) {
        			winCount++;
        		}
        	}
        }
        
        answer[1] = chkRank(winCount);
        answer[0] = chkRank(winCount+zeroCount);
        
        return answer;
    }

	private int chkRank(int count) {
		// TODO Auto-generated method stub
		switch (count) {
		case 2:
			return 5;
		case 3:
			return 4;
		case 4:
			return 3;
		case 5:
			return 2;
		case 6:
			return 1;
		default:
			return 6;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		

		Lotto_77484 sol = new Lotto_77484();
		System.out.println(sol.solution(lottos, win_nums).toString());
	}

}
