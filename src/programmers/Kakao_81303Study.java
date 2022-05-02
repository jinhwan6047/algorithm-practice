//https://programmers.co.kr/learn/courses/30/lessons/81303
//https://onlyfor-me-blog.tistory.com/317 Ǯ��
//���θ� ���� �ڵ� �м�
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
		
		StringBuilder sb = new StringBuilder(); //String ��ü���� ���Ҷ� ������ ���ο� ���ڿ��� �����ϱ� ������ �޸� �Ҵ� ������ ��ȿ�����̱⿡ StringBuilder ���
	    Stack<Integer> stack = new Stack<>(); //������ �׸� ����
	    int tableSize = n; // ǥ�� �� ����

	    for (String s : cmd) {
	      char op = s.charAt(0); // cmd���� �迭 ������� ��ɾ �о��

	      if (op == 'C') { // cmd��ɾ� ��  ���� �϶�
	        stack.push(k); //stack�� ���õ� ���� ���� ����
	        tableSize--; // ǥ�� ���Ǽ��� �ϳ� ����
	        if (k == tableSize) { // ǥ�� ���Ǽ��� ���õ� ���� ���� ������ -> k�� 0���� �����ϰ� ǥ�� �൵ 0���� �����̱� ���� 
	          k--; // k �ϳ� ����
	        }
	      } else if (op == 'Z') { // cmd��ɾ� �� �����϶�
	        int undoRow = stack.pop(); //������ �׸��� undoRow�� ����
	        if (k >= undoRow) { //undoRow���� k�� ũ�ų� ������
	          k++; //k �ϳ� �ø�
	        }
	        tableSize++; //ǥ ���� ���ϳ� �ø�
	      } else if (op == 'D') { // cmd��ɾ� ��  D�϶� 
	        k = (k + Integer.parseInt(s.split(" ")[1])) % tableSize; //*���̺������� 0���� �� ����
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