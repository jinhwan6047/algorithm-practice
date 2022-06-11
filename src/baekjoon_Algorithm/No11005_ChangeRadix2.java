package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11005_ChangeRadix2 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] strArr = str.split(" ");
		
		String b = Integer.toString(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]));
		
		System.out.println(b.toUpperCase());
		
	}
}
