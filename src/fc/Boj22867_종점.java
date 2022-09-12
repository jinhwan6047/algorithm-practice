package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj22867_종점 {
	static StringBuilder sb = new StringBuilder();
	static int n,m;
	static ArrayList<Bus> bus = new ArrayList<>();
	static PriorityQueue<String> garage = new PriorityQueue<String>();
	
	public static class Bus implements Comparable<Bus>{
		String inTime;
		String outTime;
		
		public Bus(String inTime, String outTime) {
			super();
			this.inTime = inTime;
			this.outTime = outTime;
		}

		@Override
		public int compareTo(Bus o) {
			// TODO Auto-generated method stub
			return this.inTime.compareTo(o.inTime);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			bus.add(new Bus(st.nextToken(), st.nextToken()));
		}
		Collections.sort(bus);
		
		int cnt=0;
		for(int i=0; i<bus.size(); i++) {
			Bus b = bus.get(i);
			while(!garage.isEmpty() && garage.peek().compareTo(b.inTime)<=0) {
				garage.poll();
			}
			garage.add(b.outTime);
			cnt = Math.max(cnt, garage.size());
		}
		
		System.out.println(cnt);
		
	}
}
