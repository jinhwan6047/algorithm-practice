package kakao_intern_2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lv3_등산코스정하기 {
	public static void main(String[] args) {
		int n = 6;
		int[][] paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
		int[] gates = {1,3};
		int[] summits = {5};
		
		Lv3_등산코스정하기 sol = new Lv3_등산코스정하기();
		sol.solution(n, paths, gates, summits);
	}
	
	ArrayList<Root>[] node; //길 리스트
	HashSet<Integer> gateChk; //출발점
	HashSet<Integer> summitChk; //정상
	int[] intensity; //가중치
	
	public class Root implements Comparable<Root>{
		int no;
		int w;
		public Root(int no, int w) {
			super();
			this.no = no;
			this.w = w;
		}
		
		@Override
		public int compareTo(Root o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
	}
	
	public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
			
		node = setNode(n, paths);
		gateChk = setChk(gates);
		summitChk = setChk(summits);
		
		intensity = new int[n+1];
		Arrays.fill(intensity, Integer.MAX_VALUE);
		
		djikstra(gates);
		
		int idx = -1;
		int min = Integer.MAX_VALUE;
		
		Arrays.sort(summits); // 낮은 정상번호를 얻기위해 정렬
		for(int summit : summits) {
			if(intensity[summit]<min) {
				idx = summit;
				min = intensity[summit];
			}
		}
		
		System.out.println(idx+":"+min);
			
		return new int[] {idx,min};	
	}

	private void djikstra(int[] gates) {
		Queue<Root> list = new PriorityQueue<>();
		for(int gate : gates) {
			intensity[gate] = 0; //출발점은 가중치 0
			list.add(new Root(gate, 0)); //출발점을 탐색 리스트에 추가
		}
		
		while(!list.isEmpty()) {
			Root r = list.poll();
			
			if(summitChk.contains(r.no)) continue; //현재 노드가 정상일 경우 continue -> 정상까지만 체크하면 되기 때문
			
			if(intensity[r.no]<r.w) continue; //현재 까지탐색한 w가 가중치[현재번호]보다 클 경우 continue -> 탐색할 필요가 없기때문
			
			for(Root next : node[r.no]) { //현재 노드와 연결되어있는 노드들 => 다음에 탐색할 노드				
				int w = Math.max(next.w, r.w); //현재까지 탐색한 노드와 다음 담색할 노드의 w 비교하여 더 큰값이 앞으로의 기준 가중치가 됨
				
				if(intensity[next.no]> w) { //문제 조건이 정상까지의 intensity가 최소가 될때 그중 최대의 가중치(intensity)를 찾는 것임으로 아래와 같이 데이터 갱신
					intensity[next.no] = w;
					list.add(new Root(next.no, w)); //다음 탐색을 위해 리스트에 추가
				}
			}
		}
		
		
	}

	private HashSet<Integer> setChk(int[] arr) {
		HashSet<Integer> s = new HashSet<Integer>();
		for(int i=0; i<arr.length; i++) {
			s.add(arr[i]);
		}
		return s;
	}

	private ArrayList<Root>[] setNode(int n, int[][] paths) {
		ArrayList<Root>[] r = new ArrayList[n+1];
		for(int i=0; i<n+1; i++) {
			r[i] = new ArrayList<>();
		}
		
		for(int i=0; i<paths.length; i++) {
			int[] p = paths[i];
			r[p[0]].add(new Root(p[1], p[2]));
			r[p[1]].add(new Root(p[0], p[2]));
		}
				
		return r;
	}

	
}
