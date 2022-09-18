package kakao_blind_2021;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Lv3_카드짝맞추기 {
	public static void main(String[] args) {
		int[][] board = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
		int r = 1;
		int c = 0;
		
		Lv3_카드짝맞추기 sol = new Lv3_카드짝맞추기();
		sol.solution(board, r, c);
	}
	
	int[][] map = new int[4][4];
	boolean[][] visit = new boolean[4][4];
	int[] d= {1, -1, 0, 0};
	int cardCnt=0;
	ArrayList<String> seq = new ArrayList<String>();
	int x,y;
	
	public class Pos implements Comparable<Pos>{
		int x;
		int y;
		int cnt;
		
		public Pos(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Pos o) {
			// TODO Auto-generated method stub
			return this.cnt-o.cnt;
		}
	}
	
	public int solution(int[][] board, int r, int c) {
		int answer = 0x3f3f3f3f;
			
		for(int i=0;i<4; i++) {
			for(int j=0; j<4; j++) {
				map[i][j] = board[i][j];
				if(map[i][j] != 0) cardCnt++;
			}
		}
		
		cardCnt /= 2;
		
		String card = "";
		for(int i=1; i<cardCnt+1; i++) {
			card += i;
		}
		
		combSeq(card, 0, "");
		
		for(String s : seq) {
			x=r;
			y=c;
			int sum=0;
			
			for(int i=0;i<4; i++) {
				for(int j=0; j<4; j++) {
					map[i][j] = board[i][j];
				}
			}
			
			for(int i=0; i<s.length(); i++) {
				int cardNo = s.charAt(i)-'0';
				
				sum+=search(x,y,cardNo);
				map[x][y] = 0;
				sum+=search(x,y,cardNo);
				map[x][y] = 0;		
				
				
//				int ex = x;
//				int ey = y;
//				
//				int dist1 = search(ex,ey,cardNo);
//				map[x][y] = 0;
//				int distAB = search(x,y,cardNo);
//				int dist2 = search(ex,ey,cardNo);
//				map[x][y] = 0;
//				sum += (Math.min(dist1, dist2)+distAB);
			}
			
			answer = Math.min(answer, sum);
		}
		
		System.out.println(answer);
		
		return answer;
	}

	private int search(int sx, int sy, int cardNo) {
		Queue<Pos> list = new LinkedList<>();
		list.add(new Pos(sx,sy,0));
		visit = new boolean[4][4];
		visit[sx][sy] = true;
		
		while(!list.isEmpty()) {
			Pos curP = list.poll();
			if(map[curP.x][curP.y] == cardNo) {
				x = curP.x;
				y = curP.y;
				return curP.cnt+1;
			}
			
			int nx;
			int ny;
			
			for(int i=0; i<4; i++) {
				nx = curP.x+d[i];
				ny = curP.y+d[3-i];
				if(nx>=0 && nx<4 && ny>=0 && ny<4 && !visit[nx][ny]) {
					visit[nx][ny] = true;
					list.add(new Pos(nx,ny,curP.cnt+1));
				}
			}
			
			for(int i=0; i<4; i++) {
				Pos res = ctrlMove(curP.x,curP.y, i);
				


				if(!visit[res.x][res.y]) {
					visit[res.x][res.y] = true;
					list.add(new Pos(res.x,res.y,curP.cnt+1));
				}
				
				
			}
			
		}
		return 0x3f3f3f3f;
	}



	private Pos ctrlMove(int cx, int cy, int idx) {
		cx += d[idx];
		cy += d[3-idx];
		
		while(cx>=0 && cx<4 && cy>=0 && cy<4) {
			if(map[cx][cy] != 0) {
				return new Pos(cx,cy,0);
			}
			cx += d[idx];
			cy += d[3-idx];
		}
		
		return new Pos(cx-d[idx],cy-d[3-idx],0);
	}

	public void combSeq(String card, int cnt, String comb) {
		if(cnt == cardCnt) {
			if(!seq.contains(comb)) seq.add(comb);
			return;
		}
		for(int i=0; i<card.length(); i++) {
			String str = card.substring(0, i)+card.substring(i+1);
			combSeq(str, cnt+1, comb+card.charAt(i));
		}
	}
}
