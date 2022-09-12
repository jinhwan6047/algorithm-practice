package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj22943_수 {
	static StringBuilder sb = new StringBuilder();
	static int k,m;
	static boolean[] visit = new boolean[10];
	static boolean[] isNotPrim = new boolean[98766];
	static ArrayList<Integer> stp1 = new ArrayList<Integer>(); 
	static ArrayList<Integer> stp2 = new ArrayList<Integer>(); 
	static int count=0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		k = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		chkPrime();
		combiNum(0, 0);
		divNum();

		System.out.println(count);
		
	}

	private static void divNum() {
		for(int i=0; i<stp1.size(); i++) {
			int num = stp1.get(i);
			
			while(num%m == 0) {
				num /= m;
			}
			
			for(int j=2; j<num; j++) {
				if(isNotPrim[j]) continue;
				if(num%j == 0 && !isNotPrim[num/j]) {
					stp2.add(num);
					count++;
					break;
				}
			}
		}
		
	}

	private static void combiNum(int num, int cnt) {
		if(cnt == k) {
			for(int i=2; i<num; i++) {
				if(isNotPrim[i]) continue;
				if(num != i*2 && !isNotPrim[num-i]) {
					stp1.add(num);
					return;
				}
			}
			return;
		}
		
		for(int i=0; i<10; i++) {
			if(cnt == 0 && i == 0) continue;
			if(!visit[i]) {
				visit[i] = true;
				combiNum(num+(i*(int)Math.pow(10, k-cnt-1)),cnt+1);
				visit[i] = false;
			}
		}
	}

	private static void chkPrime() {
		isNotPrim[0] = true;
		isNotPrim[1] = true;
		
		for(int i=2; i<Math.sqrt(isNotPrim.length)+1; i++) {
			if(isNotPrim[i]) continue;
			int cnt=i*2;
			while(cnt<isNotPrim.length) {
				isNotPrim[cnt] = true;
				cnt+=i;
			}
			
		}
		
	}
}
