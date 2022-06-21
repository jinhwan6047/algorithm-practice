package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No1107_Remocon {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<Integer> brokenButton = new ArrayList<>();
		
		if(m>0) {
			String str = br.readLine();
			
			for(int i=0; i<m; i++) {
				brokenButton.add(str.charAt(i*2)-'0');
			}			
		}
			
		
		int minNum = Math.abs(n-100);
		
		for(int i=0; i<=500000; i++) {
			int num = i;
			int cnt=0;
			boolean flag = true;
			if(i==0) {
				if(brokenButton.contains(0)) {
					flag = false;
				}else{
                    cnt++;
                }
			}
			while(num>0) {
				if(brokenButton.contains(num%10)) {
					cnt=0;
					flag = false;
					break;
				}
				cnt++;
				num /= 10;
			}
			if(flag) minNum = Math.min(minNum, Math.abs(n-i)+cnt);
		}

		System.out.println(minNum);
	}
}
