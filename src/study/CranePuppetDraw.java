package study;

import java.util.ArrayList;

public class CranePuppetDraw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};

		CranePuppetDraw sol = new CranePuppetDraw();
		System.out.println(sol.solution(board, moves));
	}

	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        //1. move의 순서에 따른 배열에서 인형(숫자)를 삭제한다
        for(int i=0; i<moves.length; i++) {
        	for(int j=0; j<board.length; j++) {
        		if(board[j][moves[i]-1] != 0) {
        			//2.list 마지막 숫자와 뽑은 배열의 숫자가 다르면 list에 넣어주고, 배열을 0으로 만들어준다
        			if(list.isEmpty() || (list.get(list.size()-1) != board[j][moves[i]-1])) {
        				list.add(board[j][moves[i]-1]);
        				board[j][moves[i]-1]=0;
        			//3.list 마지막 숫자와 뽑은 배열의 숫자가 같으면 list에서 마지막 숫자를 빼고 answer+2를 하고, 배열을 0으로 만들어준다
        			}else if(!list.isEmpty() && (list.get(list.size()-1) == board[j][moves[i]-1])) {
        				list.remove(list.size()-1);
        				board[j][moves[i]-1] = 0;
        				answer +=2;
        			}
        			break;
        		}
        	}
        }
        return answer;
    }
}
