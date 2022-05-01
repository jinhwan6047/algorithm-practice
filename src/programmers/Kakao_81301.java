// https://programmers.co.kr/learn/courses/30/lessons/81301
package programmers;

public class Kakao_81301 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = 0;
		String s = "123";
		String[] arr = s.split("");
		String str= "";
		String strSum = "";
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i].charAt(0) > 96) {
				str+=arr[i];
			}else {
				strSum += arr[i];
			}
			switch(str) {
			case "one" :
				strSum+="1";
				str = "";
				break;
			case "two" :
				strSum+="2";
				str = "";
				break;
			case "three" :
				strSum+="3";
				str = "";
				break;
			case "four" :
				strSum+="4";
				str = "";
				break;
			case "five" :
				strSum+="5";
				str = "";
				break;
			case "six" :
				strSum+="6";
				str = "";
				break;
			case "seven" :
				strSum+="7";
				str = "";
				break;
			case "eight" :
				strSum+="8";
				str = "";
				break;
			case "nine" :
				strSum+="9";
				str = "";
				break;
			case "zero" :
				strSum+="0";
				str = "";
				break;
			default:
				break;
			}
		}
		
		answer = Integer.valueOf(strSum);
		
		System.out.println(answer);
		
	}

}
