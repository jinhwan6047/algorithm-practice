package fastcampus_Coding369;

import java.io.*;
import java.util.*;

public class BOJ9663_NQueen {
	static int n, cnt;
	
	static void solution(int row, ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		if(row == n) {
			cnt++;
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(isAvailable(list, i)) {
				list.add(i);
				solution(row+1, list);
				list.remove(list.size()-1);
			}
		}
	}

	static boolean isAvailable(ArrayList<Integer> list, int col) {
		// TODO Auto-generated method stub
		int currentRow = list.size();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) == col || (Math.abs(list.get(i)-col) == currentRow -i)) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input();
		solution(0, new ArrayList<Integer>());
		System.out.println(cnt);
	}
	

	static void input() {
		n = scan.nextInt();
	}
	
	static StringBuilder sb = new StringBuilder();
	static FastReader scan = new FastReader();
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
