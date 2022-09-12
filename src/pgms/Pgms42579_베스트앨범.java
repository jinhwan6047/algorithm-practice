package pgms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;


public class Pgms42579_베스트앨범 {
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		Pgms42579_베스트앨범 sol = new Pgms42579_베스트앨범();
		sol.solution(genres, plays);
	}
	
	
	HashMap<String, Integer> GenPlayCnt = new HashMap<String, Integer>();
	HashMap<String, PriorityQueue<Music>> list = new HashMap<String, PriorityQueue<Music>>();	
	
	public class Music implements Comparable<Music>{
		int no;
		int cnt;
		public Music(int no, int cnt) {
			super();
			this.no = no;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Music o) {
			// TODO Auto-generated method stub
			if(o.cnt == this.cnt) return this.no-o.no;
			else return o.cnt - this.cnt;
		}
	}
	public int[] solution(String[] genres, int[] plays) {
		
		for(int i=0; i<genres.length; i++) {
			String gen = genres[i];
			int playCnt = plays[i];
			
			int tmpNum = GenPlayCnt.getOrDefault(gen, 0)+playCnt;
			GenPlayCnt.put(gen, tmpNum);
			
			PriorityQueue<Music> tmpList = list.getOrDefault(gen, new PriorityQueue<>());
			tmpList.add(new Music(i, playCnt));
			list.put(gen, tmpList);
			
		}
		
		List<Entry<String, Integer>> GenPlayCntEntry = new ArrayList<Entry<String, Integer>>(GenPlayCnt.entrySet());

		Collections.sort(GenPlayCntEntry, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
		
		ArrayList<Integer> result = new ArrayList<Integer>();

		for(Entry<String, Integer> entry : GenPlayCntEntry) {

			PriorityQueue<Music> q = list.get(entry.getKey());
			for(int i=0; i<2; i++) {
				if(!q.isEmpty()) {
					Music m = q.poll();
					result.add(m.no);
				}
			}
		}
		
		int[] answer = new int[result.size()];
		for(int i=0; i<result.size(); i++) {
			answer[i] = result.get(i);
		}
		
		return answer;
	}
}
