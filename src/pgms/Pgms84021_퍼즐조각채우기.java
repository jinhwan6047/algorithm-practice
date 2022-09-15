package pgms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Pgms84021_퍼즐조각채우기 {
	public static void main(String[] args) {
//		int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
//		int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};
		
		int[][] game_board = {{0,0,0},{1,1,0},{1,1,1}};
		int[][] table = {{1,1,1},{1,0,0},{0,0,0}};
		
		Pgms84021_퍼즐조각채우기 sol = new Pgms84021_퍼즐조각채우기();
		sol.solution(game_board, table);
	}
	
	public class Piece{
		int x;
		int y;
		public Piece(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	ArrayList<ArrayList<Piece>> puzzle = new ArrayList<>();
	ArrayList<ArrayList<Piece>> blank = new ArrayList<>();
	int n;
	int[][] game_board, table;
	boolean[][] bVisit, tVisit;
	int[] d = {1,-1,0,0};
	boolean[] pVisit;
	
	public int solution(int[][] game_board, int[][] table) {
		
		int answer = 0;
		
		this.game_board = game_board;
		this.table = table;
		n = game_board.length;
		
		bVisit = new boolean[n][n];
		tVisit = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(game_board[i][j] == 0 && !bVisit[i][j]) {
					bVisit[i][j] = true;
					search(new Piece(i,j), 0, this.game_board, bVisit);
				}
				if(table[i][j] == 1 && !tVisit[i][j]) {
					tVisit[i][j] = true;
					search(new Piece(i,j), 1, this.table, tVisit);
				}
			}
		}
		
		
		pVisit = new boolean[puzzle.size()];		
		for(int i=0; i<blank.size(); i++) {		
			
			ArrayList<Piece> b = blank.get(i);			
			for(int j=0; j<puzzle.size(); j++) {	
				
				ArrayList<Piece> p = puzzle.get(j);		
				if(b.size() == p.size() && !pVisit[j]) {
					
					boolean flag = matching(b, p);
					if(flag) {
						pVisit[j] = true;
						answer += b.size();
						break;
					}
				}
			}
		}
      
        return answer;
    }

	private boolean matching(ArrayList<Piece> b, ArrayList<Piece> p) {
		Collections.sort(b, new Comparator<Piece>() {
			@Override
			public int compare(Piece o1, Piece o2) {
				if(o1.x == o2.x) return o1.y-o2.y;
				else return o1.x - o2.x;
			}
		});
		
		for(int i=0; i<4; i++) {
			Collections.sort(p, new Comparator<Piece>() {
				@Override
				public int compare(Piece o1, Piece o2) {
					if(o1.x == o2.x) return o1.y-o2.y;
					else return o1.x - o2.x;
				}
			});
			int zx = p.get(0).x;
			int zy = p.get(0).y;
			boolean isMatched = true;
			for(int j=0; j<p.size(); j++) {
				int bx = b.get(j).x;
				int by = b.get(j).y;
				int px = p.get(j).x-zx;
				int py = p.get(j).y-zy;
				
				if(bx != px || by != py) {
					isMatched = false;
					break;
				}
			}
			
			if(isMatched) {
				return true;
			}else {
				for(int j=0; j<p.size(); j++) {
					Piece tmp = p.get(j);
					p.set(j, new Piece(tmp.y, -tmp.x));
				}
			}
		}
		
		return false;
	}

	public void search(Piece s, int type, int[][] map, boolean[][] visit) {
		Queue<Piece> list = new LinkedList<>();
		list.add(s);
		
		ArrayList<Piece> p = new ArrayList<>();
		int sx = s.x;
		int sy = s.y;
		p.add(new Piece(0,0));
		
		while(!list.isEmpty()) {
			Piece curP = list.poll();
			for(int i=0; i<4; i++) {
				int nx = curP.x+d[i];
				int ny = curP.y+d[3-i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny]==type && !visit[nx][ny]) {
					visit[nx][ny] = true;
					list.add(new Piece(nx, ny));
					p.add(new Piece(nx-sx, ny-sy));
				}
			}
		}
		
		if(type == 0) {
			blank.add(p);
		}else {
			puzzle.add(p);
		}
	}
}
