/* https://www.acmicpc.net/problem/1026
 * 옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.
 * 길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
 * S = A[0] × B[0] + ... + A[N-1] × B[N-1]
 * S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.
 * S의 최솟값을 출력하는 프로그램을 작성하시오.
 */

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
