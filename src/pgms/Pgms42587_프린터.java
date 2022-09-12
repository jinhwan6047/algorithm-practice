package pgms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class Pgms42587_프린터 {
	public static void main(String[] args) {
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		
		Pgms42587_프린터 sol = new Pgms42587_프린터();
		System.out.println(sol.solution(priorities, location));
	}
	
	Queue<Print> list = new LinkedList<>();
	int cnt=1;
	
	public class Print{
		int pri;
		int loc;
		public Print(int pri, int loc) {
			super();
			this.pri = pri;
			this.loc = loc;
		}
	}
	
	public int solution(int[] priorities, int location) {
		
		for(int i=0; i<priorities.length; i++) {
			list.add(new Print(priorities[i], i));
		}
				
        int answer = searchCnt(location);
        return answer;
    }

	public int searchCnt(int location) {
		while(true) {
			Print temp = list.poll();
			Iterator<Print> it = list.iterator();
			boolean flag = false;
			while(it.hasNext()) {
				if(temp.pri<it.next().pri) {
					list.add(temp);
					flag = true;
					break;
				}
			}
			if(!flag) {
				if(temp.loc == location) {
					return cnt;			
				}else {
					cnt++;
				}
			}
		}
	}
}
