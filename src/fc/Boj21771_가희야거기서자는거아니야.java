package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj21771_가희야거기서자는거아니야 {
	static StringBuilder sb = new StringBuilder();
	static int r,c;
	static int rg,cg, rp, cp;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map= new char[r][c];
		
		st = new StringTokenizer(br.readLine());
		rg = Integer.parseInt(st.nextToken());
		cg = Integer.parseInt(st.nextToken());
		rp = Integer.parseInt(st.nextToken());
		cp = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<r; i++) {
			String str = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int pSize = rp*cp;
		int cnt=0;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map[i][j] == 'P') cnt++;
			}
		}
		
		System.out.println(pSize==cnt?0:1);
	}
}
