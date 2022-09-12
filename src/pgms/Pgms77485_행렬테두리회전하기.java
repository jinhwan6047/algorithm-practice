package pgms;

public class Pgms77485_행렬테두리회전하기 {
	public static void main(String[] args) {
		int row=6;
		int columns=6;
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		
		Pgms77485_행렬테두리회전하기 sol = new Pgms77485_행렬테두리회전하기();
		sol.solution(row, columns, queries);
	}
	
	int[][] map;
	int minNum;
	int x1, x2, y1, y2;
	
	public int[] solution(int rows, int columns, int[][] queries) {
		map = new int[rows][columns];
		int cnt=1;
		for(int i=0; i<rows; i++) {
        	for(int j=0; j<columns; j++) {
        		map[i][j] = cnt;
        		cnt++;
        	}
        }		
        
		int[] answer = new int[queries.length];
		for(int i=0; i<queries.length; i++) {
			minNum = rows*columns;
			x1 = queries[i][0]-1;
			y1 = queries[i][1]-1;
			x2 = queries[i][2]-1;
			y2 = queries[i][3]-1;
			
			int lu = map[x1][y1];
			int ru = map[x1][y2];
			int rd = map[x2][y2];
			int ld = map[x2][y1];
			
			rotateRR(lu, y1);			
			rotateCD(ru, x1);			
			rotateRL(rd, y2);
			rotateCU(ld, x2);
			
			answer[i] = minNum;
		}
		
        return answer;
    }

	private void rotateCU(int num, int x) {
		minNum = Math.min(num, minNum);
		int nx = x-1;
		if(nx>=x1) {
			rotateCU(map[nx][y1], nx);
			map[nx][y1] = num;
		}
		
	}

	private void rotateRL(int num, int y) {
		minNum = Math.min(num, minNum);
		int ny = y-1;
		if(ny>=y1) {
			rotateRL(map[x2][ny], ny);
			map[x2][ny] = num;
		}
	}

	private void rotateCD(int num, int x) {
		minNum = Math.min(num, minNum);
		int nx = x+1;
		if(nx<=x2) {
			rotateCD(map[nx][y2], nx);
			map[nx][y2] = num;
		}
		
	}

	private void rotateRR(int num, int y) {
		minNum = Math.min(num, minNum);
		int ny = y+1;
		if(ny<=y2) {
			rotateRR(map[x1][ny], ny);
			map[x1][ny] = num;
		}
	}
	
}
