package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj22869_징검다리건너기small {
	static StringBuilder sb = new StringBuilder();
	static int n,k;
	static ArrayList<Pos> step = new ArrayList<>();
	static boolean[] visit;
	static boolean flag;
	
	public static class Pos{
		int no;
		int weight;
		public Pos(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		visit = new boolean[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) {
			step.add(new Pos(i, Integer.parseInt(st.nextToken())));
		}
		
		search();
		
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}

	private static void search() {
		Queue<Pos> list = new LinkedList<>();
		list.add(step.get(0));
		
		while(!list.isEmpty()) {
			Pos p = list.poll();
			for(int i=p.no+1; i<p.no+k; i++) {
				if(step.size()<=i) continue;
				
				Pos np = step.get(i);
				if(!visit[np.no]&&(i-p.no)*(1+(Math.abs(np.weight-p.weight)))<=k) {
					visit[np.no] = true;
					if(i==step.size()-1) {
						flag = true;
						return;
					}else {
						list.add(np);
					}
				}
			}
		}
		
	}
}
