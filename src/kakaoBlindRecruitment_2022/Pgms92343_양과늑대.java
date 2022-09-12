package kakaoBlindRecruitment_2022;


//실패
import java.util.ArrayList;
import java.util.HashMap;

public class Pgms92343_양과늑대 {
	public static void main(String[] args) {
		int[] info = {0,1,0,1,1,0,1,0,0,1,0};
		int[][] edges = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}};
		
		Pgms92343_양과늑대 sol = new Pgms92343_양과늑대();
		sol.solution(info, edges);
	}
	
	HashMap<Integer, ArrayList<Integer>> node = new HashMap<>();
	int maxNum = 0;
	int[] map;
	
	public int solution(int[] info, int[][] edges) {
        int answer = 0;
        
        map= info;
        
        for(int[] edge : edges) {
        	int parent = edge[0];
        	
        	ArrayList<Integer> temp = node.getOrDefault(parent, new ArrayList<>());
        	temp.add(edge[1]);
        	node.put(parent, temp);        	
        }
        
        search(0, 0, 0, new ArrayList<Integer>());
        
//        System.out.println(maxNum);
        
        return answer;
    }

	public void search(int curNode, int wolf, int sheep, ArrayList<Integer> nextList) {
		if(map[curNode] == 0) {
			sheep++;
		}else if(map[curNode] == 1) {
			wolf++;
		}
		
		if(sheep>wolf) {
			maxNum = Math.max(maxNum, sheep);
		}else {
			return;
		}
		
		if(node.get(curNode) != null) {
			nextList.addAll(node.get(curNode));
		}
		
		System.out.println(curNode+" : "+nextList);
		for(int i=0; i<nextList.size(); i++) {
			int nextNode = nextList.get(i);
			int nAni = map[nextNode];
			if(nAni != 2) {
//				nextList.remove(i);
				map[nextNode] = 2;
				search(nextNode, wolf, sheep, nextList);
//				nextList.add(i, nextNode);	
				map[nextNode] = nAni;
			}
		}
		
	}
}
