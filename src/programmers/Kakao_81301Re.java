// https://programmers.co.kr/learn/courses/30/lessons/81301
// 다른사람 풀이 방식
package programmers;

public class Kakao_81301Re {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = 0;
		String s = "one1two2three3fourfive";
		
		String[] before = {"one","two","three","four","five","six","seven","eight","nine","zero"};
		String[] after = {"1","2","3","4","5","6","7","8","9","0"};

		for(int i=0; i<before.length; i++) {
			s=s.replaceAll(before[i], after[i]);
		}
		answer = Integer.valueOf(s);
		System.out.println(answer);
	}

}
