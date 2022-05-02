//https://programmers.co.kr/learn/courses/30/lessons/81303
//https://onlyfor-me-blog.tistory.com/317 풀이
//공부를 위해 코드 분석
package programmers;

import java.util.Stack;

public class Kakao_81303Study {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		int k = 2;
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		
		
		System.out.println(solution(n, k, cmd));
	}
	
	
	public static String solution(int n, int k, String[] cmd) {
		
		StringBuilder sb = new StringBuilder(); //String 객체끼리 더할때 구조상 새로운 문자열을 생성하기 때문에 메모리 할당 문제로 비효율적이기에 StringBuilder 사용
	    Stack<Integer> stack = new Stack<>(); //삭제한 항목 저장
	    int tableSize = n; // 표의 행 갯수

	    for (String s : cmd) {
	      char op = s.charAt(0); // cmd에서 배열 순서대로 명령어를 읽어옴

	      if (op == 'C') { // cmd명령어 중  삭제 일때
	        stack.push(k); //stack에 선택된 행의 값을 넣음
	        tableSize--; // 표의 행의수를 하나 줄임
	        if (k == tableSize) { // 표의 행의수와 선택된 행의 값이 같을때 -> k도 0부터 시작하고 표의 행도 0부터 시작이기 때문 
	          k--; // k 하나 줄임
	        }
	      } else if (op == 'Z') { // cmd명령어 중 복구일때
	        int undoRow = stack.pop(); //삭제된 항목을 undoRow에 삽입
	        if (k >= undoRow) { //undoRow보다 k가 크거나 같으면
	          k++; //k 하나 올림
	        }
	        tableSize++; //표 행의 수하나 올림
	      } else if (op == 'D') { // cmd명령어 중  D일때 
	        k = (k + Integer.parseInt(s.split(" ")[1])) % tableSize; //*테이블사이즈는 0부터 행 시작
	      } else {
	        k = (k - Integer.parseInt(s.split(" ")[1])) % tableSize;
	      }
	    }

	    for(int i = 0; i < tableSize; i++) {
	      sb.append("O");
	    }

	    while(!stack.isEmpty()) {
	      sb.insert(stack.pop(), "X");
	    }

	    return sb.toString();
	}
	
	
}