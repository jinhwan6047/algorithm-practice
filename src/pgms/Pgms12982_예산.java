package pgms;

import java.util.ArrayList;

public class Pgms12982_예산 {
	public static void main(String[] args) {
		int[] d = {2,2,3,3};
		int budget = 10;
		
		Pgms12982_예산 sol = new Pgms12982_예산();
		sol.solution(d, budget);
	}
	public int solution(int[] d, int budget) {
		ArrayList<Integer> dList = new ArrayList<Integer>();
		for(int num : d) {
			dList.add(num);
		}
		
		ArrayList<Integer> sortList = quickSort(dList);
		
		int answer = 0;
		for(int num : sortList) {
			budget -= num;
			if(budget<0) {
				break;
			}
			answer++;
		}
		
        return answer;
    }
	public ArrayList<Integer> quickSort(ArrayList<Integer> list) {

		if(list.size() <= 1) {
			return list;
		}
		
		int pivot = list.get(0);

		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		
		for(int i=1; i<list.size(); i++) {
			if(list.get(i)>pivot) {
				right.add(list.get(i));
			}else {
				left.add(list.get(i));
			}
		}
		
		ArrayList<Integer> mergeList = new ArrayList<Integer>();
		mergeList.addAll(quickSort(left));
		mergeList.add(pivot);
		mergeList.addAll(quickSort(right));
		
		return mergeList;
	}
}
