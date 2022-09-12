package pgms;

import java.util.LinkedList;
import java.util.Queue;

public class Pgms81302_거리두기확인하기 {
	public static void main(String[] args) {
		String[][] places = {{"POOOP", 
			  "OXXOX", 
			  "OPXPX", 
			  "OOXOX", 
			  "POXXP"},

          {"POOPX", 
			 "OXPXP", 
			 "PXXXO", 
			 "OXXXO", 
			 "OOOPP"},
          
          {"PXOPX", 
			 "OXOXP", 
			 "OXPOX", 
			 "OXXOP", 
			 "PXPOX"},
          
          {"OOOXX", 
			 "XOOOX", 
			 "OOOXX", 
			 "OXOOX", 
			 "OOOOO"},
          
          {"PXPXP", 
			 "XPXPX", 
			 "PXPXP", 
			 "XPXPX", 
			 "PXPXP"}}; 
		
		Pgms81302_거리두기확인하기 sol = new Pgms81302_거리두기확인하기();
		sol.solution(places);
	}
	
	char[][] map;
	int idx=0;
	int[] d = {1,-1,0,0};
	boolean[][] visit;
	
	public class Pos{
		int x; int y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public int[] solution(String[][] places) {
		
		int[] answer = new int[places.length];
		
		for(String[] str : places) {
			map = new char[5][5];
			answer[idx]= 1;
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					map[i][j] = str[i].charAt(j);
				}
			}
			
			boolean flag=true;
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					if(map[i][j] == 'P' && flag) {
						visit= new boolean[5][5];
						flag = searchMap(i, j);						
					}
				}
			}
			answer[idx]=flag==true?1:0;
			idx++;
		}
//		for(int num : answer) {
//			System.out.println(num);
//		}
       
        return answer;
    }
	public boolean searchMap(int x, int y) {
//		System.out.println(x+" "+y+" "+map[x][y]);
		Queue<Pos> list = new LinkedList<>();
		list.add(new Pos(x,y));
		visit[x][y] = true;
		while(!list.isEmpty()) {
			Pos temp = list.poll();
			for(int i=0; i<4; i++) {
				int nx = temp.x+d[i];
				int ny = temp.y+d[3-i];
				
				if(nx>=0&&nx<5&&ny>=0&&ny<5&&(Math.abs(x-nx)+Math.abs(y-ny))<=2 && !visit[nx][ny]) {
//					System.out.println(nx+" : "+ny+" : "+" : "+(Math.abs(x-nx)+Math.abs(y-ny)));
					visit[nx][ny] = true;
					if(map[nx][ny] == 'X') {
						continue;
					}else if(map[nx][ny] == 'O') {
						list.add(new Pos(nx,ny));
					}else if(map[nx][ny] == 'P') {
						return false;
					}
				}
			}
		}
		return true;
	}
}
