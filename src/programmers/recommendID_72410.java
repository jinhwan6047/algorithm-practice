package programmers;

public class recommendID_72410 {
	public String solution(String new_id) {
		//1.소문자로
		new_id = new_id.toLowerCase();
		//2. 특수문자제거
		new_id = new_id.replaceAll("[^0-9a-z-_.]", "");	
		//3. .../.. -> . 변환
		while(new_id.contains("..")) {
			new_id = new_id.replace("..", ".");
		}
		//4. 처음/끝에 .제거
		if(!new_id.isEmpty() && new_id.charAt(0) == '.') {
			new_id = new_id.substring(1);
		}
		if(!new_id.isEmpty() && new_id.charAt(new_id.length()-1) == '.') {
			new_id = new_id.substring(0, new_id.length()-2);
		}
		//5. 빈문자열 일때 a 대입
		if(new_id.isEmpty()) {
			new_id = "a";
		}
		//6.길이 15자 제한 및 . 처리
		if(new_id.length()>15) {
			new_id = new_id.substring(0, 15);
		}
		if(new_id.charAt(new_id.length()-1) == '.') {
			new_id = new_id.substring(0, new_id.length()-1);
		}
		//7. 2자이하 처리
		while(new_id.length()<3) {
			new_id += new_id.charAt(new_id.length()-1);
		}
		
		
		return new_id;
     }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String new_id = "...";
		recommendID_72410 sol = new recommendID_72410();
		System.out.println(sol.solution(new_id));
	}

}
