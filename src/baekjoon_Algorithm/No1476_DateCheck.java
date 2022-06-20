package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1476_DateCheck {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int e = 1;
		int s = 1;
		int m = 1;
		
		String str = br.readLine();		
		String[] num = str.split(" ");
		
		int year=1;
		while(true) {
			if(e==Integer.parseInt(num[0]) && s==Integer.parseInt(num[1]) && m==Integer.parseInt(num[2])) {
				break;
			}
			e++;
			s++;
			m++;
			if(e>15) {
				e=1;
			}
			if(s>28) {
				s=1;
			}
			if(m>19) {
				m=1;
			}
			year++;
		}
		
		System.out.println(year);
	}
}
