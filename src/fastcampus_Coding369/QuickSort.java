package fastcampus_Coding369;

import java.util.ArrayList;

public class QuickSort {
	
	public ArrayList<Integer> quickSort(ArrayList<Integer> unsortedData){
		if(unsortedData.size()<=1) {
			return unsortedData; 
		}
		int pivot = unsortedData.get(0); 
		ArrayList<Integer> sortList = new ArrayList<Integer>();
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
		for(int i=1; i<unsortedData.size();i++) {
			if(pivot<unsortedData.get(i)) {
				right.add(unsortedData.get(i));
			}else {
				left.add(unsortedData.get(i));
			}
		}
		sortList.addAll(quickSort(left));
		sortList.add(pivot);
		sortList.addAll(quickSort(right));
		
		return sortList;
	}

	public static void main(String[] args) {
		// 테스트용 randomData 생성
		ArrayList<Integer> randomData = new ArrayList<Integer>();
		for(int i=0; i<100; i++) {
			randomData.add((int)(Math.random()*1000));
		}
		//정렬 전 Data
		System.out.println(randomData.toString());
		
		//정렬 실행
		QuickSort qs = new QuickSort();
		//정렬결과
		System.out.println(qs.quickSort(randomData).toString());
	}

}
