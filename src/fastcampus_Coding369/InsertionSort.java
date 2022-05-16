package fastcampus_Coding369;

import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {
	
	public ArrayList<Integer> insertionSort(ArrayList<Integer> radomData){
		for(int i=1; i<radomData.size(); i++) {
			for(int j=i; j>0; j--) {
				if(radomData.get(j)<radomData.get(j-1)) {
					Collections.swap(radomData, j, j-1);
				}
			}
		}
		return radomData;
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
		InsertionSort Is = new InsertionSort();
		//정렬결과
		System.out.println(Is.insertionSort(randomData).toString());
	}

}
