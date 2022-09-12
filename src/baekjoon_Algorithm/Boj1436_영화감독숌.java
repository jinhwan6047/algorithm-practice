package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj1436_영화감독숌 {
	static StringBuilder sb = new StringBuilder();
	static int n;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int i = 666;
		while(list.size() != n) {
			String str = Integer.toString(i);
			if(str.contains("666")) {
				list.add(i);
			}
			i++;
		}
		
		System.out.println(list.get(n-1));
	}
}
