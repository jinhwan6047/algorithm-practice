package kakao_intern_2022;

public class Lv3_코딩테스트공부 {
	public static void main(String[] args) {
//		int alp = 10;
//		int cop = 10;
//		int[][] numbers = {{10,15,2,1,2},{20,20,3,3,4}};
		
		
//		int alp = 0;
//		int cop = 0;
//		int[][] numbers = {{0,0,2,1,2},{4,5,3,1,2},{4,11,4,0,2},{10,4,0,4,2}};
		
		int alp = 10;
		int cop = 10;
		int[][] numbers = {{9,9,2,1,2},{8,11,3,3,4}};
		
		Lv3_코딩테스트공부 sol = new Lv3_코딩테스트공부();
		sol.solution(alp, cop, numbers);
	}
	
	Integer[][] dp;
	int[][] problems;
	
	public int solution(int alp, int cop, int[][] problems) {
		this.problems = problems;
		int alpMax = 0;
		int copMax = 0;
		for(int[] p : problems) {			
			alpMax = Math.max(alpMax, p[0]);
			copMax = Math.max(copMax, p[1]);
		}
		
		if(alpMax<alp) {
			alpMax = alp;
		}
		if(copMax<cop) {
			copMax = cop;
		}
		dp = new Integer[alpMax+1][copMax+1];
		for(int i=0; i<alpMax+1; i++) {
			for(int j=0; j<copMax+1; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		dp[alp][cop] = 0;
		
		
		for(int i=alp; i<=alpMax; i++) {
			for(int j=cop; j<=copMax; j++) {
				if(i<alpMax) {				
					dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);					
				}
				if(j<copMax) {
					dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);					
				}
				for(int k=0; k<problems.length; k++) {
					int[] p = problems[k];
					int alp_req = p[0];
					int cop_req = p[1];
					int alp_rwd = p[2];
					int cop_rwd = p[3];
					int cost = p[4];
					
					if(i>=alp_req && j>=cop_req) {
						if(i+alp_rwd>alpMax && j+cop_rwd>copMax) {
							dp[alpMax][copMax] = Math.min(dp[alpMax][copMax], dp[i][j]+cost);
						}else if(i+alp_rwd>alpMax){
							dp[alpMax][j+cop_rwd] = Math.min(dp[alpMax][j+cop_rwd], dp[i][j]+cost);
						}else if(j+cop_rwd>copMax) {
							dp[i+alp_rwd][copMax] = Math.min(dp[i+alp_rwd][copMax], dp[i][j]+cost);
						}else {
							dp[i+alp_rwd][j+cop_rwd] = Math.min(dp[i+alp_rwd][j+cop_rwd], dp[i][j]+cost);
						}					
						
					}
					
				}
			}
		}
		

		int answer = dp[alpMax][copMax];
        return answer;
    }
}
