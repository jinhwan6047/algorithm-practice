package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;


public class Boj21942_부품부여대장 {
	static StringBuilder sb = new StringBuilder();
	static int n, f;
	static int ddd, hh, mm;
	static HashMap<String, HashMap<String, Date>> list = new HashMap<>(); 
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	static HashMap<String, Long> result = new HashMap<String, Long>();

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		String l = st.nextToken();
		f = Integer.parseInt(st.nextToken());
		 
		ddd = Integer.parseInt(l.substring(0, 3));
		hh = Integer.parseInt(l.substring(4, 6));
		mm = Integer.parseInt(l.substring(7));
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			String d = st.nextToken();
			String t = st.nextToken();
			String item = st.nextToken();
			String name = st.nextToken();
			
			chk(d, t, item, name);	
		}
		
		if(result.isEmpty()) {
			sb.append("-1");
		}else {
			Iterator<Map.Entry<String, Long>> it = result.entrySet().iterator();
			ArrayList<String> nameList = new ArrayList<String>();
			while(it.hasNext()) {
				Map.Entry<String, Long> temp = it.next();
				nameList.add(temp.getKey());
			}
			Collections.sort(nameList);
			for(String name : nameList) {
				sb.append(name+" ").append(result.get(name)).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void chk(String d, String t, String item, String name) {
		HashMap<String, Date> rentMap = list.getOrDefault(name, new HashMap<String, Date>());
		try {
			Date date = sdf.parse(d+" "+t);			
			if(!rentMap.containsKey(item)) {
				rentMap.put(item, date);
				list.put(name, rentMap);				
			}else {
				Date rentDate = rentMap.get(item);
				
				long rentDays= (date.getTime()-rentDate.getTime())/60000-(ddd*24*60+hh*60+mm);
				if(rentDays>0) {
					result.put(name, result.getOrDefault(name, (long)0)+(Long)rentDays*f);
				}
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
