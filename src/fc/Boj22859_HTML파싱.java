package fc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj22859_HTML파싱 {
	static StringBuilder sb = new StringBuilder();
	static String str;
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		
		str = str.replace("<main>", "");
		str = str.replace("</main>", "");
		
		String[] divTag = str.split("</div>");
		
		int divNum = divTag.length;
		for(int i=0; i<divNum; i++) {
			String getDiv = divTag[i].substring(0, divTag[i].indexOf(">"));
			getTitle(getDiv);
			
			String pStr = divTag[i].substring(divTag[i].indexOf(">")+1);
			String[] pTag = pStr.split("</p>");
			int pNum = pTag.length;
			for(int j=0; j<pNum; j++) {
				getP(pTag[j]);
			}
		}
		
		System.out.println(sb);
	}


	private static void getP(String p) {
		String temp = p.replace("<p>", "");
		while(temp.contains("<")) {
			int sIdx = temp.indexOf("<");
			int eIdx = temp.indexOf(">");
			temp = temp.substring(0, sIdx) + temp.substring(eIdx+1); 
		}
		temp = temp.replaceAll("  ", " ");
		
		sb.append(temp).append("\n");
	}


	private static void getTitle(String div) {
		String tempTitle = div.substring(div.indexOf("title=")+7);
		String title = tempTitle.substring(0, tempTitle.indexOf("\""));
		sb.append("title : "+title).append("\n");
	}
}
