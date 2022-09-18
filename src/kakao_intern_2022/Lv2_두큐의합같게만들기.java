package kakao_intern_2022;

import java.util.LinkedList;
import java.util.Queue;

public class Lv2_두큐의합같게만들기 {
	public static void main(String[] args) {
		int[] queue1 = {3, 2, 7, 2};
		int[] queue2 = {4, 6, 5, 1};
		
		Lv2_두큐의합같게만들기 sol = new Lv2_두큐의합같게만들기();
		sol.solution(queue1, queue2);
	}
	
	Queue<Long> que1 = new LinkedList<Long>();
	Queue<Long> que2 = new LinkedList<Long>();
	int answer = Integer.MAX_VALUE;
	int n;
	long chkNum;
	
	public int solution(int[] queue1, int[] queue2) {
		
		long sum = 0;
        n = queue1.length;
        for(int i=0; i<n; i++) {
        	que1.add((long) queue1[i]);
        	que2.add((long) queue2[i]);
        	sum+=queue1[i];
        	sum+=queue2[i];
        }
        if(sum%2 != 0) return -1;
        
        chkNum = sum/2;
        
        search(0, que1, que2);
        
        System.out.println(answer); 
        return answer;
    }

	private void search(int cnt, Queue<Long> q1, Queue<Long> q2) {
		
		long sumQ1 = sum(q1);
		while(cnt != n*4) {
			if(sumQ1 == chkNum) {
				answer = Math.min(answer, cnt);
				return;
			}
			if(sumQ1>chkNum) {
				long num = q1.poll();
				sumQ1-=num;
				q2.add(num);
			}else {
				long num = q2.poll();
				sumQ1+=num;
				q1.add(num);
			}
			cnt++;
		}
		answer = -1;
	}

	private long sum(Queue<Long> q1) {
		long sum=0;
		for(long num : q1) {
			sum+=num;
		}
		return sum;
	}
}
