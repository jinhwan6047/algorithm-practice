package study;

public class RankingSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] info = {"java backend junior pizza 150",
						 "python frontend senior chicken 210",
						 "python frontend senior chicken 150",
						 "cpp backend senior pizza 260",
						 "java backend junior chicken 80",
						 "python backend senior chicken 50"};
		
		String[] query = {"java and backend and junior and pizza 100",
				          "python and frontend and senior and chicken 200",
				          "cpp and - and senior and pizza 250",
				          "- and backend and senior and - 150",
				          "- and - and - and chicken 100",
				          "- and - and - and - 150"};
		
		RankingSearch sol = new RankingSearch();
		int[] result = sol.solution(info, query);
		
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}

	public int[] solution(String[] info, String[] query) {
		//1. info배열을 hashmap에 문자와 숫자로 구분해서 저장, 띄어쓰기를 구분자로 4번째 배열이 점수
		//query를 and 구분자로 hashmap에 저장  4번째 배열이 점수
		for(int i=0; i<info.length; i++) {
			String[] info2 = info[i].split(" ");			
		}
		//2. query의 key에 해당하는 info key를 찾아 value비교
		//3. 비교된 결과를 answer에 담아 준다
		int[] answer = {};
        return answer;
    }
}
