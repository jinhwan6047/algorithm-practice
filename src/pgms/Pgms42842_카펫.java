package pgms;

public class Pgms42842_카펫 {
	public static void main(String[] args) {
		int brown = 16;
		int yellow = 9;
		
		Pgms42842_카펫 sol = new Pgms42842_카펫();
		sol.solution(brown, yellow);
	}
	public int[] solution(int brown, int yellow) {
		
		int hMax = (int)Math.sqrt(yellow);
		
		int[] answer = new int[2];
		for(int i=1; i<=hMax; i++) {
			int bNum = ((yellow/i)*2)+(i*2)+4;
			if(bNum == brown) {
				answer[0] = (yellow/i)+2;
				answer[1] = i+2;
			}
		}
		
		
		return answer;
	}
}
