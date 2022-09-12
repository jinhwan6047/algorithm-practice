package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7562_나이트의이동 {
	static StringBuilder sb = new StringBuilder();
	static int l; //체스판 크기
	static boolean[][] visit; //체스판 및 방문 여부 체크
	static int[][] map; //이동 횟수 체크 지도
	static knight s; //시작좌표
	static knight goal; //목표좌표
	static int[] dx = {-2,-1, 1, 2, 2, 1,-1,-2}; //방향
	static int[] dy = { 1, 2, 2, 1,-1,-2,-2,-1}; //방향
	
	static class knight{
		int x;
		int y;
		
		knight(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());  //테스트케이스 수
		
		for(int i=0; i<n; i++) {
			l = Integer.parseInt(br.readLine());
			visit = new boolean[l][l];
			map = new int[l][l];
			
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			s = new knight(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			st=new StringTokenizer(br.readLine()," ");
			goal = new knight(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			move();
			
		}
		
		System.out.println(sb);
		
	}

	static void move() {
		Queue<knight> list = new LinkedList<>();
		list.add(s);
		visit[s.x][s.y]=true;
		
		while(!list.isEmpty()) {
			knight temp = list.poll();
			if(temp.x == goal.x && temp.y == goal.y) {
				sb.append(map[temp.x][temp.y]).append("\n");
				return;
			}
			
			for(int i=0; i<8; i++) {
				int nx = temp.x+dx[i];
				int ny = temp.y+dy[i];
				
				if(nx>=0 && ny>=0 && nx<l && ny<l && !visit[nx][ny]) {
					map[nx][ny] = map[temp.x][temp.y]+1;
					visit[nx][ny] = true;
					list.add(new knight(nx, ny));
				}
			}
		}
	}
}
