package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11576_BaseConversion {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//진법 입력
		String str = br.readLine();
		//입력된 진법을 
		String[] strArr = str.split(" ");
		
		int n = Integer.parseInt(br.readLine());
		String num = br.readLine();
		String[] numArr = num.split(" ");
		
		int before = Integer.parseInt(strArr[0]);
		int after = Integer.parseInt(strArr[1]);
		
		long number=0;
		for(int i=0; i<n; i++) {
			number += Long.parseLong(numArr[numArr.length-1-i])*Math.pow(before, i);
		}
		while(number>=after) {
			sb.insert(0, number%after+" ");
			number /= after;
		}
		sb.insert(0, number+" ");
		System.out.println(sb);
	}
}
