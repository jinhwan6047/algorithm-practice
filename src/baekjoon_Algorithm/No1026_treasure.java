package baekjoon_Algorithm;

import java.util.*;

public class No1026_treasure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		int num = 0;
		int sum=0;
		
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		for(int i=0; i<n; i++) {
			b[i] = sc.nextInt();
		}
		
		
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-i-1; j++) {
				if(a[j]<a[j+1]) {
					num = a[j];
					a[j] = a[j+1];
					a[j+1] = num;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			num=0;
			for(int j=0; j<n; j++) {
				if(b[i]>b[j]) {
					num++;
				}
			}
			c[num] = i+1;
		}
		
		for(int i=0; i<n; i++) {
			if(c[i] != 0) {
				sum += a[i]*b[c[i]-1];				
			}else {
				int count = i;
				while(c[count] == 0) {
					count--;
				}
				sum += a[i]*b[c[count]-1];
			}
		}
		
		System.out.println(sum);
	}

}
