package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj21940_가운데서만나기 {
	static StringBuilder sb = new StringBuilder();
	static int n,m;
	static int[][] map;
	static int[] result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][n+1];
		
		
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<n+1; j++) {
				if(i==j) {
					map[i][j] = 0;
				}else {
					map[i][j] = 1001;
				}
			}
		}
				
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int n1= Integer.parseInt(st.nextToken());
			int n2= Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			map[n1][n2] = Math.min(map[n1][n2], dis);
		}
		
		int k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				for(int l=1; l<n+1; l++) {
					map[j][l] = Math.min(map[j][l], map[j][i]+map[i][l]);
				}
			}
		}
		
		result = new int[n+1];
		for(int i=0; i<k; i++) {
			int num = Integer.parseInt(st.nextToken());
			for(int j=1; j<n+1; j++) {
				result[j] = Math.max(result[j], map[num][j]+map[j][num]);
			}
		}
		
		int chkNum = Integer.MAX_VALUE;
		ArrayList<Integer> idx = new ArrayList<Integer>();
		for(int i=1; i<n+1; i++) {

			if(result[i]<chkNum) {
				chkNum = result[i];
				idx = new ArrayList<Integer>();
				idx.add(i);
			}else if(result[i]==chkNum) {
				idx.add(i);
			}
		}
		for(int num : idx) {
			System.out.print(num+" ");
		}
	}
}
