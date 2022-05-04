package study;

public class ReportResult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k= 2;
		
		ReportResult sol = new ReportResult();
		int[] result = sol.solution(id_list, report, k);
		
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i]);
		}
	}

	public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        return answer;
    }
}
