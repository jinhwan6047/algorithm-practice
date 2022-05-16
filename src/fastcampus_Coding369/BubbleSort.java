package fastcampus_Coding369;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
	
	public ArrayList<Integer> bubbleSort(ArrayList<Integer> randomData){
		
		for(int i=0; i<randomData.size()-1; i++) {
			boolean flag = true;
			for(int j=0; j<randomData.size()-1-i;j++) {
				if(randomData.get(j)>randomData.get(j+1)) {
					Collections.swap(randomData, j, j+1);
					flag = false;
				}
			}
			if(flag) break;
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
		
		//버블정렬 실행
		BubbleSort bs = new BubbleSort();
		System.out.println(bs.bubbleSort(randomData).toString());

	}

}
