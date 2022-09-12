package pgms;

import java.util.ArrayList;

public class Pgms87946_피로도 {
	public static void main(String[] args) {
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}};
		
		Pgms87946_피로도 sol = new Pgms87946_피로도();
		sol.solution(k, dungeons);
	}
	
	boolean[] visit;
	ArrayList<Dun> list = new ArrayList<>();
	int num;
	int answer = -1;
	
	public class Dun{
		int needFati;
		int consumFati;
		public Dun(int needFati, int consumFati) {
			super();
			this.needFati = needFati;
			this.consumFati = consumFati;
		}	
	}

	public int solution(int k, int[][] dungeons) {
		
		num = dungeons.length;
		for(int i=0; i<num; i++) {
			int[] temp = dungeons[i];
			list.add(new Dun(temp[0], temp[1]));
		}
		
		visit = new boolean[num];
		
		search(k, 0);
		
		return answer;
	}

	public void search(int curFati, int cnt) {
		answer = Math.max(answer, cnt);
		
		for(int i=0; i<num; i++) {
			Dun tmp = list.get(i);
			if(tmp.needFati<=curFati && !visit[i]) {
				visit[i] = true;
				search(curFati-tmp.consumFati, cnt+1);
				visit[i] = false;
			}
		}
		
	}
}
