package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj2529_부등호 {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static String[] ine;
	static boolean[] visit;
	static int[] arr;
	static ArrayList<String> result;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		ine = str.split(" ");
		visit = new boolean[n+1];
		
		
		System.out.println(result.toString());
	}
}
