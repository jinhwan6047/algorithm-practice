package pgms;

import java.util.ArrayList;
import java.util.Collections;

public class Pgms86491_최소직사각형 {
	public static void main(String[] args) {
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		
		Pgms86491_최소직사각형 sol = new Pgms86491_최소직사각형();
		sol.solution(sizes);
	}
	public int solution(int[][] sizes) {
		
		ArrayList<Integer> height = new ArrayList<Integer>();
		ArrayList<Integer> width = new ArrayList<Integer>();
	
		for(int[] num : sizes) {
			int n1 = num[0];
			int n2 = num[1];
			if(n1>n2) {
				height.add(n1);
				width.add(n2);
			}else {
				height.add(n2);
				width.add(n1);
			}
		}
		
		int hMax = Collections.max(height);
		int wMax = Collections.max(width);
		
		int result = hMax*wMax;
		
		return result;
	}
}
