package fastcampus_Coding369;

public class BOJ15651_NandM1 {
	int n;
	int m;
	int[] result, used;
	
	public void solution(int n, int m) {
		this.n = n;
		this.m = m;
		this.result = new int[m];
		this.used = new int[n];
		
		recur(0);
	}
	
	public void recur(int k) {
		if(k == m) {
			for(int i=0; i<m; i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
		}else {
			for(int i=0; i<n; i++) {
				if(used[i] == 1) {
					continue;
				}
				result[k] = i+1;
				used[i] = 1;
				
				recur(k+1);
				used[i] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int m = 4;
		
		BOJ15651_NandM1 sol = new BOJ15651_NandM1();
		sol.solution(n, m);
		
	}

}
