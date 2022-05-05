package study;

import java.util.HashMap;

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
		//1. info 배열을 HashMap에 넣는다 key:문자열 value:점수
		// 1) 항목이 "-" 일때 도 포함하여 infoHash 작성
		HashMap<String, Integer> infoHash = new HashMap<>();
		for(int i=0; i<info.length; i++) {
			String[] str = info[i].split(" ");
			String[] language = {"-",str[0]};
			String[] position = {"-",str[1]};
			String[] experance = {"-",str[2]};
			String[] favoriteFood = {"-",str[3]};
			String sumStr="";
			for(String lan : language) {
				for(String posi : position) {
					for(String exp : experance) {
						for(String food : favoriteFood) {
							sumStr = lan+posi+exp+food;
							infoHash.put(sumStr, Integer.valueOf(str[str.length-1]));
						}
					}
				}
			}
		}
		System.out.println(infoHash.keySet());
		System.out.println(infoHash.values());
		//2. query를 info의 key값과 같이 재작성, 점수는 다른 변수 만들어서 저장
		//3. query에 만족하는 infoHash의 key가 있는지 확인
		//4. answer에 검색결과 반영
		int[] answer = {};
        return answer;
    }
}
