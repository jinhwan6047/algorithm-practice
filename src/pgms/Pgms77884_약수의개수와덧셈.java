package pgms;

public class Pgms77884_약수의개수와덧셈 {
	public static void main(String[] args) {
		int left = 24;
		int right = 27;
		
		Pgms77884_약수의개수와덧셈 sol = new Pgms77884_약수의개수와덧셈();
		sol.solution(left, right);
	}
	public int solution(int left, int right) {
		
		int answer = 0;
		for(int i=left; i<right+1; i++) {
			int cnt=0;
			for(int j=1; j<=Math.sqrt(i); j++) {
				if(i%j == 0 && j != i/j) {
					cnt += 2;
				}
				if(i%j == 0 && j == i/j) {
					cnt++;
				}
			}
			answer += cnt%2 == 0 ? i:-i;
		}
        return answer;
    }
}
