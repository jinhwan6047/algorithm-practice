// programmers.co.kr/learn/courses/30/lessons/42577
// ��ȭ��ȣ�ο� ���� ��ȭ��ȣ�� ���� �迭 phone_book �� solution �Լ��� �Ű������� �־��� ��, 
// � ��ȣ�� �ٸ� ��ȣ�� ���ξ��� ��찡 ������ false�� �׷��� ������ true�� return �ϵ��� solution �Լ��� �ۼ����ּ���.
package study;

public class PhoneNumber_List {

	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		PhoneNumber_List sol = new PhoneNumber_List();
		System.out.println(sol.solution1(phone_book));
	}

	//Loop�� Ȱ���� ���� 
	//�׳� Loop�� ����ϸ� �迭�� �ϳ��ϳ� ��� ���ϴ� ���̱� ������ �迭�� ���̿� ���� �ʹ� ������� ��ȿ����
	// 1) Sorting : ��ȭ��ȣ�� ������������ sorting
	// 2) �� : �ѹ��� ������ ���鼭 �ΰ��� ���ڸ� ��
	// 3) ���ξ� Ȯ�� : ���� ���ڰ� ���� ������ ���ξ����� Ȯ���Ͽ� ������ ã�´�
	//    -> sorting�� �߱⶧���� �յ��� ���ڸ� ���ϸ� �迭�� �ϳ��ϳ� ��� ���� �ʿ䰡 ����
	
	public boolean solution1(String[] phone_book) {
		//1. phone_book�� �����Ѵ�
		//2. 1�� loop�� ���鼭 �չ�ȣ�� �޹�ȣ�� ���ξ����� Ȯ���Ѵ�
		//3. ������� �Դµ� ������ ã�� ���ߴٸ� ���ξ ���ٴ� ���̴�.
        boolean answer = true;
        return answer;
    }
}
