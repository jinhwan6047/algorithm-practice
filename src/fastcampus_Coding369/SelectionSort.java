package fastcampus_Coding369;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
	public ArrayList<Integer> selectionSort(ArrayList<Integer> randomData){
		
		for(int i=0; i<randomData.size(); i++) {
			Integer lowNum = i;
			for(int j=i+1; j<randomData.size(); j++) {
				if(randomData.get(lowNum)>randomData.get(j)) {
					lowNum = j;
				}
			}
			Collections.swap(randomData, i, lowNum);
		}
		
		return randomData;
	}

	public static void main(String[] args) {
		// 테스트용 randomData 생성
		ArrayList<Integer> randomData = new ArrayList<Integer>();
		for(int i=0; i<100; i++) {
			randomData.add((int)(Math.random()*100));
		}
		//정렬 전 Data
		System.out.println(randomData.toString());
		
		//정렬 실행
		SelectionSort ss = new SelectionSort();
		//정렬결과
		System.out.println(ss.selectionSort(randomData).toString());

	}

}
