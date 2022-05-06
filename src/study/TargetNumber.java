package study;

public class TargetNumber {
	int answer=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {4, 1, 2, 1};
		int target = 4;
		TargetNumber sol = new TargetNumber();
		System.out.println(sol.solution(numbers, target));
	}

	public int solution(int[] numbers, int target) {
		
		dfs(0,0,numbers,target);        		
        return answer;
    }

	public void dfs(int index, int sum, int[] numbers, int target) {
		
		if(index == numbers.length) {
			if(sum == target) {
				answer++;
			}
			return;
		}
		
		dfs(index+1, sum+numbers[index], numbers, target);
		dfs(index+1, sum-numbers[index], numbers, target);
	}
	
}
