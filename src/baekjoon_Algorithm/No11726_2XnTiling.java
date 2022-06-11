package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11726_2XnTiling {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		//타일링 메모이제이션 배열
		int[] tile  = new int[n+2];
		tile[0] = 0;
		tile[1] = 1;
		tile[2] = 3;
		//타일링 다이나믹프로그램
	
	}
}
