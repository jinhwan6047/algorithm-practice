package pgms;

import java.util.LinkedList;
import java.util.Queue;

public class Pgms43162_네트워크 {
	public static void main(String[] args) {
		int n=3;
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		
		Pgms43162_네트워크 sol = new Pgms43162_네트워크();
		sol.solution(n, computers);
	}
	
	int [][] map;
	boolean[] visit;
	public int solution(int n, int[][] computers) {
		int answer = 0;
		
		map = computers;
		visit = new boolean[n];
		
		for(int i=0; i<n; i++) {
			if(!visit[i]) {
				answer++;
				visit[i] = true;
				search(i, n);
			}
		}
		
		System.out.println(answer);
		return answer;
	}
	public void search(int num, int n) {
		Queue<Integer> list = new LinkedList<Integer>();
		list.add(num);
		
		while(!list.isEmpty()) {
			int curNo = list.poll();
			for(int i=0; i<n; i++) {
				if(curNo == i) continue;
				if(!visit[i] && map[curNo][i] == 1) {
					visit[i] = true;
					list.add(i);
				}
			}
		}
		
	}
}
