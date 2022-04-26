package baekjoon_Algorithm;

import java.util.Scanner;

public class No11399_ATM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		
		int num=0;
		
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-i-1; j++) {
				if(arr[j]>arr[j+1]) {
					num = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = num;
				}
			}
		}
		
		num=0;
		int sum=0;
		for(int i=0; i<n; i++) {
			sum += num+arr[i];
			num += arr[i];
			
		}
		
		System.out.println(sum);
	

	}

}