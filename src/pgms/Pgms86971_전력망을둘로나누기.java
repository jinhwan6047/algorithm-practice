package pgms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Pgms86971_전력망을둘로나누기 {
	public static void main(String[] args) {
		int n =9;
		int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
		
		
		Pgms86971_전력망을둘로나누기 sol = new Pgms86971_전력망을둘로나누기();
		sol.solution(n, wires);
	}
	
	ArrayList<Integer>[] list;
	
	public int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;
		
		list = new ArrayList[n+1];
		for(int i=0; i<n+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
				
		
		for(int i=0; i<n-1; i++) {
			int n1 = wires[i][0];
			int n2 = wires[i][1];
			
			list[n1].add(n2);
			list[n2].add(n1);
		}
		
		for(int i=0; i<n-1; i++) {
			int num = search(i, wires);
			answer = Math.min(answer, Math.abs(n-num*2));
		}
		
		return answer;
	}

	public int search(int num, int[][] wires) {
		int n1 = wires[num][0];
		int n2 = wires[num][1];
		
		boolean[] visit = new boolean[wires.length+2];
		
		int cnt=0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n2);
		visit[n2] = true;
		
		while(!q.isEmpty()) {
			cnt++;
			ArrayList<Integer> tmpList = list[q.poll()];
			for(int i=0; i<tmpList.size(); i++) {
				int tmpNum = tmpList.get(i);
				if(!visit[tmpNum] && tmpNum != n1) {
					
					visit[tmpNum] = true;
					q.add(tmpNum);					
				}
				
				
			}
		}
		
		return cnt;
		
		
	}
}
