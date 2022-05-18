package fastcampus_Coding369;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
	public boolean binarySearch(ArrayList<Integer> list, int n) {
		if(list.size() == 0) {
			return false;
		}
		if(list.size() == 1 && list.get(0) == n) {
			return true;
		}
		if(list.size() == 1 && list.get(0) != n) {
			return false;
		}
		
		int midNum = list.size()/2;
		if(list.get(midNum) == n) {
			return true;
		}else {
			if(list.get(midNum) > n) {
				return binarySearch(new ArrayList<Integer>(list.subList(0, midNum)), n);
			}else {
				return binarySearch(new ArrayList<Integer>(list.subList(midNum, list.size())), n);
			}
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort ms = new MergeSort();
		BinarySearch bs = new BinarySearch();
		Integer[] list = new Integer[100];
		for(int i=0; i<list.length; i++) {
			list[i] = (int)(Math.random()*100);
		}
		int n = 1;
		
		ArrayList<Integer> listArr = new ArrayList<>(Arrays.asList(list));
		ArrayList<Integer> sortList = ms.splitList(listArr);
		System.out.println(sortList.toString());
		boolean result = bs.binarySearch(sortList, n);
		System.out.println(result);
	}

}
