package baekjoon_Algorithm;

import java.util.Scanner;

public class No2839_sugarFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num=-1;
		
		loop:
		for(int i=0; i<(n/3)+1; i++) {
			for(int j=0; j<(n/5)+1; j++) {
				if((n-(5*j)-(3*i)) == 0) {
					num = j+i;
					break loop;
				}
			}
		}
		
		System.out.println(num);
		
	}

}
