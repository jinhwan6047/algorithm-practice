package pgms;

import java.util.ArrayList;
import java.util.Collections;

public class Pgms42748_K번째수 {
	public static void main(String[] args) {
		int[] array = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		Pgms42748_K번째수 sol = new Pgms42748_K번째수();
		sol.solution(array, commands);
	}
	public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
		int[] answer = new int[len];
		ArrayList<Integer> list;
        
        for(int i=0; i<len; i++) {
        	list = new ArrayList<Integer>();
        	for(int j=commands[i][0]-1; j<commands[i][1]; j++) {
        		list.add(array[j]);
        	}
        	Collections.sort(list);
        	answer[i] = list.get(commands[i][2]-1);
        }
        
        return answer;
    }
}
