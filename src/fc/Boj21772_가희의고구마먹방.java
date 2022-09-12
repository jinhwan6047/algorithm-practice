package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj21772_가희의고구마먹방 {
	static StringBuilder sb = new StringBuilder();
	static int r,c,t;
	static char[][] map;
	static int max=0;
	static int[] d = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		map= new char[r][c];
		int x=0;
		int y=0;
		
		for(int i=0; i<r; i++) {
			String str = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'G') {
					x = i;
					y = j;
				}
			}
		}
		search(x, y, 0, 0);
		System.out.println(max);
	}

	private static void search(int x, int y, int time, int cnt) {
		if(time == t) {
			max = Math.max(max, cnt);
			return;
		}
		for(int i=0; i<4; i++) {
			int nx = x+d[i];
			int ny = y+d[3-i];
			
			if(nx>=0 && nx<r && ny>=0 && ny<c && map[nx][ny] !='#') {
				if(map[nx][ny] == 'S') {
					map[nx][ny] = '.';
					search(nx,ny,time+1,cnt+1);
					map[nx][ny] = 'S';
				}else {
					search(nx,ny,time+1,cnt);
				}
			}
		}
		
	}
}
