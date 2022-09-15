package pgms;

public class Pgms43163_단어변환 {
	public static void main(String[] args) {
		String begin = "hit"; 
		String target = "cog"; 
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
//		String[] words = {"hot", "dot", "dog", "lot", "log"};
		
		
		Pgms43163_단어변환 sol = new Pgms43163_단어변환();
		System.out.println(sol.solution(begin, target, words));
	}
	
	String target;
	String[] words;
	int answer = Integer.MAX_VALUE;
	boolean[] visit;
	
	public int solution(String begin, String target, String[] words) {
		
		
		this.target = target;
		this.words = words;
		
		visit = new boolean[words.length];
		boolean chk = true;
		for(String str : words) {
			if(str.equals(target)) chk = false;
		}
		
		if(chk) return 0;
		
		search(begin, 0);
		
		return answer;
	}

	private void search(String str, int cnt) {
		System.out.println(str);
		if(str.equals(target)) {
			answer = Math.min(answer, cnt);
			return;
		}
		
		for(int i=0; i<words.length; i++) {
			
			if(diff(str, words[i]) == 1 && !visit[i]) {
				visit[i] = true;
				search(words[i], cnt+1);
				visit[i] = false;
			}
		}
		
	}

	private int diff(String str, String string) {
		if(str.equals(string)) return 0;
		
		int result = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) != string.charAt(i)) result++;
		}
		
		return result;
	}
}
