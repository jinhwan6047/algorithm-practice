package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Boj1991_트리순회 {
	static StringBuilder sb = new StringBuilder();
	static HashMap<Character, node> list = new HashMap<>();
	
	public static class node{
		Character left;
		Character right;
		
		
		public node(Character left, Character right) {
			super();
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());//입력 노드 수
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			list.put(str.charAt(0), new node(str.charAt(2), str.charAt(4)));
		}
		
		preorder('A');
		sb.append("\n");
		inorder('A');
		sb.append("\n");
		postorder('A');
		System.out.println(sb);
		
	}

	public static void postorder(char c) {
		if(list.get(c).left != '.') {
			postorder(list.get(c).left);
		}	
		if(list.get(c).right != '.') {
			postorder(list.get(c).right);
		}
		sb.append(c);
	}

	public static void inorder(char c) {
		if(list.get(c).left != '.') {
			inorder(list.get(c).left);
		}
		sb.append(c);
		if(list.get(c).right != '.') {
			inorder(list.get(c).right);	
		}
		
	}

	public static void preorder(Character c) {
		sb.append(c);
		
		if(list.get(c).left != '.') {
			preorder(list.get(c).left);
		}
		if(list.get(c).right != '.') {
			preorder(list.get(c).right);
		}
	}
}
