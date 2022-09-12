package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj22860_폴더정리small {
	static StringBuilder sb = new StringBuilder();
	static int n,m;
	static HashMap<String, ArrayList<String>> folderMap = new HashMap<String, ArrayList<String>>();
	static HashMap<String, ArrayList<String>> fileMap = new HashMap<String, ArrayList<String>>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n+m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String parent = st.nextToken();
			String child = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			
			if(num ==1) {
				ArrayList<String> temp = folderMap.getOrDefault(parent, new ArrayList<String>());
				temp.add(child);
				folderMap.put(parent, temp);
			}else if(num == 0) {
				ArrayList<String> temp = fileMap.getOrDefault(parent, new ArrayList<String>());
				temp.add(child);
				fileMap.put(parent, temp);
			}			
		}
		
		int q = Integer.parseInt(br.readLine());
		for(int i = 0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			chkQuery(st.nextToken());
		}
		
		System.out.println(sb);
	}

	private static void chkQuery(String query) {
		String[] str = query.split("/");
		String folder = str[str.length-1];
		
		
		ArrayList<String> numberList = new ArrayList<String>();
		HashSet<String> kindList = new HashSet<String>();

		if(fileMap.containsKey(folder)) {
			numberList.addAll(fileMap.get(folder));
			kindList.addAll(fileMap.get(folder));			
		}
		
		Queue<String> childFolder  = new LinkedList<String>();
		if(folderMap.containsKey(folder)) {
			childFolder.addAll(folderMap.get(folder));			
		}
		while(!childFolder.isEmpty()) {
			String f = childFolder.poll();
			if(fileMap.containsKey(f)) {
				numberList.addAll(fileMap.get(f));
				kindList.addAll(fileMap.get(f));			
			}
			if(folderMap.containsKey(f)) {
				childFolder.addAll(folderMap.get(f));			
			}

		}
		
		sb.append(kindList.size()+" "+numberList.size()).append("\n");
	}
}
