package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2309_Dwarf {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] num = new int[9];
		int sum=0;
		for(int i=0; i<9; i++) {
			num[i] = Integer.parseInt(br.readLine());
			sum += num[i];
		}
		
		loop:
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				if(sum-num[i]-num[j] == 100) {
					num[i]=0;
					num[j]=0;
					break loop;
				}
			}
		}
		
		Arrays.sort(num);
		
		for(int i=2; i<9; i++) {
			System.out.println(num[i]);
		}
		
	}
}
