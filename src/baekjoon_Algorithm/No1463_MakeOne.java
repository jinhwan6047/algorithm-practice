package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1463_MakeOne {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int cnt=0;
		while(n>1) {
			if(n%3==0) {
				n /= 3;
				cnt++;
			}else if(n%3==1) {;
				n--;
				n /=3;
				cnt +=2;
			}else if(n%2==0) {
				n /=2;
				cnt++;
			}else {
				n--;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
