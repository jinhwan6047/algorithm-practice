package fastcampus_Coding369;

import java.util.ArrayList;

public class MergeSort {
	
	public ArrayList<Integer> splitList(ArrayList<Integer> unsortedData){
		if(unsortedData.size()<=1) {
			return unsortedData;
		}
		
		int midNum = unsortedData.size()/2;
		ArrayList<Integer> left = splitList(new ArrayList<Integer>(unsortedData.subList(0, midNum)));
		ArrayList<Integer> right = splitList(new ArrayList<Integer>(unsortedData.subList(midNum, unsortedData.size())));
				
		return mergeList(left, right);
	}
	
	public ArrayList<Integer> mergeList(ArrayList<Integer> left, ArrayList<Integer> right){
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		while(left.size()>0 && right.size()>0) {
			if(left.get(0)>right.get(0)) {
				list.add(right.remove(0));
			}else {
				list.add(left.remove(0));
			}
		}
		while(left.size()>0) {
			list.add(left.remove(0));
		}
		while(right.size()>0) {
			list.add(right.remove(0));
		}
		return list;
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
		MergeSort ms = new MergeSort();
		//정렬결과
		System.out.println(ms.splitList(randomData).toString());

	}

}
