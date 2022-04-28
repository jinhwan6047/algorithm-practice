package baekjoon_Algorithm;

import java.util.*;

public class No11047_coin0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int money = sc.nextInt();
		int[] arr = new int[n];
		int count = 0;
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		loop:
		while(true) {
			for(int i=n-1; i>=0; i--) {				
				if(money == 0) {
					break loop;
				}
				if(money>=arr[i]) {
					money -= arr[i];
					count++;
					break;
				}
			}
		}
		
		System.out.println(count);
	}

}
