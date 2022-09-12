package pgms;

import java.util.HashMap;

public class Pgms67256_키패드누르기 {
	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		
		Pgms67256_키패드누르기 sol = new Pgms67256_키패드누르기();
		sol.solution(numbers, hand);
		
	}
	public class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public String solution(int[] numbers, String hand) {
		HashMap<String, Pos> hands = new HashMap<>();
		hands.put("left", new Pos(3, 0));
		hands.put("right", new Pos(3, 2));
		String answer = "";
		
		for(int num : numbers) {
			if(num==1 || num==4 || num==7) {
				answer += "L";
				hands.put("left", new Pos(num/3, 0));
			}else if(num==3 || num==6 || num==9) {
				answer += "R";
				hands.put("right", new Pos(num%3==0?(num/3)-1:num/3, 2));
			}else if(num==2 || num==5 || num==8) {
				int x = num/3;
				int y = 1;
				
				int rDistance = Math.abs(x-hands.get("right").x)+Math.abs(y-hands.get("right").y);
				int lDistance = Math.abs(x-hands.get("left").x)+Math.abs(y-hands.get("left").y);

				if(rDistance>lDistance) {
					answer += "L";
					hands.put("left", new Pos(num/3, 1));
				}else if(rDistance<lDistance) {
					answer += "R";
					hands.put("right", new Pos(num/3, 1));
				}else if(rDistance==lDistance){
					answer += hand.substring(0, 1).toUpperCase();
					hands.put(hand, new Pos(num/3, 1));
				}
			}else if(num==0) {
				int x = 3;
				int y = 1;
				
				int rDistance = Math.abs(x-hands.get("right").x)+Math.abs(y-hands.get("right").y);
				int lDistance = Math.abs(x-hands.get("left").x)+Math.abs(y-hands.get("left").y);

				if(rDistance>lDistance) {
					answer += "L";
					hands.put("left", new Pos(3, 1));
				}else if(rDistance<lDistance) {
					answer += "R";
					hands.put("right", new Pos(3, 1));
				}else if(rDistance==lDistance){
					answer += hand.substring(0, 1).toUpperCase();
					hands.put(hand, new Pos(3, 1));
				}
				
			}
			
		}
        return answer;
    }
}
