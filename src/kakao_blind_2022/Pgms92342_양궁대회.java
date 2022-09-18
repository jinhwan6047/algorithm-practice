package kakao_blind_2022;

import java.util.Arrays;

public class Pgms92342_양궁대회 {
	public static void main(String[] args) {
		int n = 1;
		int[] info = {1,0,0,0,0,0,0,0,0,0,0};
		
		Pgms92342_양궁대회 sol = new Pgms92342_양궁대회();
		sol.solution(n, info);
	}

	int[] answer = new int[11];
	int max = 0;
	int[] apa;
	
	public int[] solution(int n, int[] info) {
		apa = info;
		
		search(n, 0, new int[11]);
		
		if(max<=0) {
			int[] result = {-1};
			System.out.println("-1");
			return result;
		}
		
		for(int num : answer) System.out.print(num+" ");
		
		return answer;
	}

	private void search(int cnt, int idx, int[] ry) {
		if(idx == 11) {
			if(cnt>0) {
				ry[10] += cnt;
			}
			int rySum=0;
			int apaSum=0;
			for(int i=0; i<11; i++) {
				if(ry[i]>0) {
					rySum += 10-i;
				}else if(ry[i]<=apa[i] && apa[i]!=0) {
					apaSum += 10-i;
				}
			}
			if(max<rySum-apaSum) {
				max = rySum-apaSum;				
				answer = ry;
			}else if(max==rySum-apaSum) {
				for(int j=10; j>=0; j--) {
					if(ry[j]>answer[j]) {
						answer = ry;
						return;
					}else if(ry[j]<answer[j]){
                        return;
                    }
				}
			}
			return;
		}

		if(apa[idx]<cnt) {
			int[] copyRy1 = Arrays.copyOf(ry, 11);
			copyRy1[idx] = apa[idx]+1;
			search(cnt-copyRy1[idx], idx+1, copyRy1);
		}
		
		search(cnt, idx+1, ry);
		
	}

	
}