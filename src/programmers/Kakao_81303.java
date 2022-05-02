//https://programmers.co.kr/learn/courses/30/lessons/81303
package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Kakao_81303 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String answer = "";
		 int n=8;
		 String[] result = new String[n];
		 Arrays.fill(result, "O");
		 int count = n;
		 int k=2;
		 int sel = k-1;
		 String[] cmd={"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		 String[] action;
		 
		 Stack<Integer> stack = new Stack<Integer>();
		 
		 
		 
		 LinkedList<Integer> li = new LinkedList<Integer>();
		 for(int i=0; i<n; i++) {
			 li.add(i);
		 }
		 
		 for(int i=0; i<cmd.length; i++) {
			 action = cmd[i].split(" ");
			 
			 if(action[0].equals("D")) {
				 sel += Integer.valueOf(action[1]);
			 }else if(action[0].equals("U")) {
				 sel -= Integer.valueOf(action[1]);
			 }else if(action[0].equals("C")) {
				 result[li.get(sel)] = "X";
				 stack.push(li.get(sel));
				 li.remove(sel);
				 count--;
				 if(sel>count) {
					sel--;
				 }
			 }else if(action[0].equals("Z")) {
				 int insert = stack.pop();
				 li.add(insert, insert);
				 result[insert] = "O";
				 count++;
			 }
		 }
		 
		 for(int i=0; i<n; i++) {
			 answer += result[i];
		 }
		 
		 System.out.println(answer);
	}

}

//		 for(int i=0; i<cmd.length; i++) {
//			 action = cmd[i].split(" ");
//			 
//			 if(action[0].equals("D")) {
//				 k += Integer.valueOf(action[1]);
//			 }else if(action[0].equals("U")) {
//				 k -= Integer.valueOf(action[1]);
//			 }else if(action[0].equals("C")) {
//				 stack.push(k-1);
//				 map.put(k-1, k-1);
//				 count--;
//				 if(k>count) {
//					 k--;
//				 }
//			 }else if(action[0].equals("Z")) {
//				 map.remove(stack.pop());
//				 count++;
//			 }
//			 
//			 //System.out.println("k : "+k+", count : "+ count);
//		 }

//		 for(int i=0; i<n; i++) {
//			 if(map.containsKey(i)) {
//				 answer += "X";
//			 }else {
//				 answer += "O";
//			 }
//		 }