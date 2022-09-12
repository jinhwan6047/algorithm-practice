package pgms;

import java.util.HashSet;

public class Pgms42862_체육복 {
	public static void main(String[] args) {
		int n = 3;
		int[] lost = {3};
		int[] reverse = {1};
		
		Pgms42862_체육복 sol = new Pgms42862_체육복();
		
		int result = sol.solution(n, lost, reverse);
		System.out.println(result);
	}
	public int solution(int n, int[] lost, int[] reserve) {
		HashSet<Integer> lostSet = new HashSet<Integer>();
		HashSet<Integer> reserveSet = new HashSet<Integer>();
		
		for(int num : reserve) {
			reserveSet.add(num);
		}
		
		for(int num : lost) {
			if(reserveSet.contains(num)) {
				reserveSet.remove(num);
			}else {
				lostSet.add(num);
			}
		}
		
		for(int num : reserveSet) {
			if(lostSet.contains(num-1)) {
				lostSet.remove(num-1);
			}else if(lostSet.contains(num+1)) {
				lostSet.remove(num+1);
			}
		}
        
        return n-lostSet.size();
    }
}
