package baekjoon_Algorithm;

import java.util.Scanner;

public class No2839_sugarFactoryRe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num=0;
		
		while(true) {
			if(n%5 ==0) {
				num += n/5;
				break;
			}else if(n<0) {
				num = -1;
				break;
			}
			num ++;
			n -= 3;
		}
		
		System.out.println(num);
	}

}
