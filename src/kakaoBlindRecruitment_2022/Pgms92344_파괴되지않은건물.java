package kakaoBlindRecruitment_2022;


public class Pgms92344_파괴되지않은건물 {
	public static void main(String[] args) {
		int[][] board = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] skill = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};
		
		Pgms92344_파괴되지않은건물 sol = new Pgms92344_파괴되지않은건물();
		sol.solution(board, skill);
	}
	int[][] score;
	public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int row = board.length;
        int col = board[0].length;
        score = new int[row][col];
        
        for(int[] s : skill) {
        	int div = s[0];
        	int sRow = s[1];
        	int sCol = s[2];
        	int eRow = s[3];
        	int eCol = s[4];
        	int point = div==2?s[5]:-s[5];
        	
        	score[sRow][sCol] += point;
        	if(eRow+1<row) score[eRow+1][sCol] -= point;
        	if(eCol+1<col) score[sRow][eCol+1] -= point;
        	if(eRow+1<row && eCol+1<col) score[eRow+1][eCol+1] += point;
        }
        
        for(int i=0; i<col; i++) {
        	for(int j=1; j<row; j++) {
        		score[j][i] += score[j-1][i];
        	}
        }
        for(int i=0; i<row; i++) {
        	for(int j=1; j<col; j++) {
        		score[i][j] += score[i][j-1];
        	}
        }
        
        for(int i=0; i<row; i++) {
        	for(int j=0; j<col; j++) {
        		int result = board[i][j]+score[i][j];
        		if(result>0) answer++;
        	}
        }
        
        return answer;
    }

	
	
// 아래 코드 정확성 통과, 효율성 모두 실패
//	public int solution(int[][] board, int[][] skill) {
//        int answer = 0;
//        
//        for(int[] num : skill) {
//        	int div = num[0];
//        	int sRow = num[1];
//        	int sCol = num[2];
//        	int eRow = num[3];
//        	int eCol = num[4];
//        	int point = num[5];
//        	for(int i=sRow; i<=eRow; i++) {
//        		for(int j=sCol; j<=eCol; j++) {
//        			if(div == 1) {
//        				board[i][j] -= point;
//        			}else {
//        				board[i][j] += point;
//        			}
//        		}
//        	}
//        }
//        
//        for(int[] arr : board) {
//        	for(int num : arr) {
//        		if(num>0) answer++;
//        	}
//        }
//        
//        return answer;
//    }
}
