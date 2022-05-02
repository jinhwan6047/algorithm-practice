//���� Ǭ Ǯ�̴� ���������� �ذ�Ǿ����� ä������ ��κ� �����̰� ȿ���� �׽�Ʈ�� ��� ����
package programmers;

import java.util.HashMap;
import java.util.Stack;

public class Kakao_81303 {

	public static void main(String[] args) {
		int n = 8;
		int k = 2;
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		
		
		System.out.println(solution(n, k, cmd));
	}

	public static String solution(int n, int k, String[] cmd) {
		Stack<Integer> stack = new Stack<Integer>();
		HashMap<Integer, Integer>map = new HashMap<>();
		String[] action;
		int count = n;
		for(int i=0; i<n; i++) {
			map.put(i, 1);
		}
		
		for(int i=0; i<cmd.length; i++) {
			 action = cmd[i].split(" ");
			 
			 if(action[0].equals("D")) {
				 k += Integer.valueOf(action[1]);
			 }else if(action[0].equals("U")) {
				 k -= Integer.valueOf(action[1]);
			 }else if(action[0].equals("C")) {
				 stack.push(k);
				 map.remove(k+1);
				 count--;
				 if(k == count) {
					 k--;
				 }
			 }else if(action[0].equals("Z")) {
				 int num = stack.pop();
				 map.put(num,1);
				 if(k>=num) {
					 k++;
				 }
				 count++;
			 }		
		}
		
		String answer="";
		for(int i=0; i<n; i++) {
			if(map.containsKey(i)) {
				 answer += "O";
			}else {
				 answer += "X";
			}
		}
		
		return answer;
	}
}
