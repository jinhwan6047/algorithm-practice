package fastcampus_Coding369;

public class BOJ15651_NandM3 {
	int n;
	int m;
	int[] result;
	
	public void solution(int n, int m) {
		this.n = n;
		this.m = m;
		this.result = new int[m];
		
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
				result[k] = i+1;
				
				recur(k+1);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int m = 3;
		
		BOJ15651_NandM3 sol = new BOJ15651_NandM3();
		sol.solution(n, m);
		
	}

}
