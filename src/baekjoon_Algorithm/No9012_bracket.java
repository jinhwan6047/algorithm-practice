package baekjoon_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No9012_bracket {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), "()", true);
			chk_vps(st);
		}
		
		System.out.println(sb);
	}

	static void chk_vps(StringTokenizer st) {
		// TODO Auto-generated method stub
		int cnt=0;
		
		if(st == null) {
			sb.append("NO").append("\n");
			return;
		}
		if(st.nextToken().equals(")")) {
			sb.append("NO").append("\n");
			return;
		}else {
			cnt++;
		}
		while(st.hasMoreTokens()) {
			if(cnt<0) {
				sb.append("NO").append("\n");
				return;
			}
			if(st.nextToken().equals("(")) {
				cnt++;
			}else {
				cnt--;
			}
		}
		if(cnt == 0) {
			sb.append("YES").append("\n");
		}else {
			sb.append("NO").append("\n");
		}
	}

}

/* 다른사람 풀이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        Stack<Character> st;
        for(int test = 0; test<t;test++){
            st = new Stack<>();
            String input = br.readLine();
            String result = is_vpn(st, input) ? "YES" : "NO";
            System.out.println(result);
        }

    }

    private static boolean is_vpn(Stack<Character> st, String input) {
        for(int i = 0; i< input.length(); i++){
            char c= input.charAt(i);
            if(c=='(') st.push(c);
            else{
                if(st.isEmpty()) return false;
                char st_result = st.pop();
                if(st_result != '(') return false;
            }
        }
        return st.isEmpty();
    }
}
*/
