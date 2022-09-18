package kakaoBlindRecruitment_2022;

public class Pgms92335_K진수에서소수개수구하기 {
	public static void main(String[] args) {
		int n = 1000000;
		int k = 8;
		
		Pgms92335_K진수에서소수개수구하기 sol = new Pgms92335_K진수에서소수개수구하기();
		sol.solution(n, k);
	}
	
	public int solution(int n, int k) {
		int answer = 0;
		
		String chgNum = Integer.toString(n, k);
		String[] splitNum = chgNum.split("0");

		
		for(int i=0; i<splitNum.length;i++) {
			if(splitNum[i].equals("")) continue;
			if(isPrime(splitNum[i])) {
				answer++;
			}
		}
		
		System.out.println(answer);
		return answer;
	}

	public boolean isPrime(String str) {
		Long num = Long.parseLong(str);
		if(num == 1) return false;
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i==0) 
				return false;
		}
		
		return true;
	}
}
