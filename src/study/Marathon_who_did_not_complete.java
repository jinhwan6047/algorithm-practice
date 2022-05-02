//https://programmers.co.kr/learn/courses/30/lessons/42576
//�����濡 ������ �������� �̸��� ��� �迭 participant�� ������ �������� �̸��� ��� �迭 completion�� �־��� ��, 
//�������� ���� ������ �̸��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
package study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Marathon_who_did_not_complete {

	public static void main(String[] args) {
		String[] part = {"leo", "kiki", "eden"};
		String[] comp = {"leo", "kiki"};
		Marathon_who_did_not_complete sol = new Marathon_who_did_not_complete();
		System.out.println(sol.solution1(part,comp));
		System.out.println(sol.solution2(part,comp));
		System.out.println(sol.solution3(part,comp));
	}
	

	// Sorting/Loop�� ����Ͽ� ���� �ذ��
	// 1) �� list�� sorting
	// 2) completion list�� length��ŭ 1:1�� ���鼭 participant���� �����ϴ� �Ѹ��� ã�´�
	// 3) list�� ���� �� ������ ���� ���ٸ� participant�� ������ ���ڰ� �������� ���Ѱ� 
	public String solution1(String[] participant, String[] completion) {
        //1. �� �迭�� ����
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        //2. �� �迭�� �ٸ� ������ ã�´�
        int i=0;
        for(; i<completion.length; i++) {
        	if(!participant[i].equals(completion[i])) {
        		break;
        	}
        }
        
        //3. ������� �Դٸ�, ������ ���ڰ� �������� ���Ѱ�
        // �� for�� ���鼭  participant�� completion�� ���� �ٸ� i ���� ã�´ٸ� ã�� i��° participant�� ����
        // for���� �ٵ��Ƶ� �ٸ����� ��ã�Ҵٸ� ������(for���� ������ i��°) participant�� ����
        return participant[i];
    }
	
	
	// Hash�� Ȱ���� ���� �ذ�
	// 1) Hash����� : key�� ���� �̸���, value��Count�� ���� HashMap�� �����
	// 2) Hash���� : completion�� �����ϴ� ��������Hash�� ����
	// 3) ������ ���� : Value�� �����ִ� ������ �������� ���� �����̴�
	public String solution2(String[] participant, String[] completion) {
		String answer ="";
		//1. Hash Map�� ����� (participant)
		HashMap<String, Integer> map = new HashMap<>();
		for(String player : participant) {
			//���������� ������ �ֱ� ������ getOrDefalut�� �����
			map.put(player, map.getOrDefault(player, 0) + 1);//������ ���� player�� �����ٸ� 0����, �־��ٸ� +1
		}
		
		//2. Hash Map�� ����(completion)
		for(String player : completion) {
			//completion�� �մ� ����� participant�� ���ԵǾ��ִ°��� Ȯ���ϱ� ������ getOrDefault�� ������� �ʾƵ� ��
			map.put(player, map.get(player) -1);
		}
		//3. value�� 0�� �ƴ� ������ ���ڸ� ã�´�.
		for(String key : map.keySet()) {
			if(map.get(key) != 0) {
				answer = key;
				break;
			}
		}
		
		return answer;
	}
	
	
	// Hash�� Ȱ���� ���� �ذ�2 - entrySet �̿�
	// 1,2�� ���� Hash�� Ȱ���� ���� �ذ�1�� ����� ���� 3������ entrySet���̿�
	// �ݺ������� entrySet�� ������ �� ���� ������ keySet���� �����
	public String solution3(String[] participant, String[] completion) {
		String answer ="";
		//1. Hash Map�� ����� (participant)
		HashMap<String, Integer> map = new HashMap<>();
		for(String player : participant) {
			//���������� ������ �ֱ� ������ getOrDefalut�� �����
			map.put(player, map.getOrDefault(player, 0) + 1);//������ ���� player�� �����ٸ� 0����, �־��ٸ� +1
		}
		
		//2. Hash Map�� ����(completion)
		for(String player : completion) {
			//completion�� �մ� ����� participant�� ���ԵǾ��ִ°��� Ȯ���ϱ� ������ getOrDefault�� ������� �ʾƵ� ��
			map.put(player, map.get(player) -1);
		}
		//3. value�� 0�� �ƴ� ������ ���ڸ� ã�´�.
		Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator(); //Iterator�� �ݺ����� ���� ���ִ� class
		
		while(iter.hasNext()) {
			Map.Entry<String, Integer> entry = iter.next();
			if(entry.getValue() !=0) {
				answer = entry.getKey();
				break;
			}
		}
		return answer;
	}
}
