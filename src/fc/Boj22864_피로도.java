package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj22864_피로도 {
	static StringBuilder sb = new StringBuilder();
	static int a,b,c,m;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		a = Integer.parseInt(st.nextToken());//피로도
		b = Integer.parseInt(st.nextToken());//처리량
		c = Integer.parseInt(st.nextToken());//회복
		m = Integer.parseInt(st.nextToken());//한계치
		
		int healthChk=0;
		int workChk=0;
		for(int i=0; i<24; i++) {
			if(healthChk+a<=m) {
				workChk += b;
				healthChk += a;
			}else {
				healthChk -= c;
				if(healthChk<0) healthChk=0;
			}
		}
		
		System.out.println(workChk);
	}
}
