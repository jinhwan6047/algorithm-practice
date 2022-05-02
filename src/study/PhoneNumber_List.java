// programmers.co.kr/learn/courses/30/lessons/42577
// 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 
// 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
package study;

public class PhoneNumber_List {

	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		PhoneNumber_List sol = new PhoneNumber_List();
		System.out.println(sol.solution1(phone_book));
	}

	//Loop를 활용한 문제 
	//그냥 Loop를 사용하면 배열을 하나하나 모두 비교하는 것이기 때문에 배열의 길이에 따라 너무 오래결려 비효율적
	// 1) Sorting : 전화번호를 오름차순으로 sorting
	// 2) 비교 : 한번의 루프만 돌면서 두개의 숫자를 비교
	// 3) 접두어 확인 : 앞의 숫자가 뒤의 수자의 접두어인지 확인하여 정답을 찾는다
	//    -> sorting을 했기때문에 앞뒤의 숫자만 비교하면 배열을 하나하나 모두 비교할 필요가 없다
	
	public boolean solution1(String[] phone_book) {
		//1. phone_book을 정렬한다
		//2. 1중 loop를 돌면서 앞번호가 뒷번호의 접두어인지 확인한다
		//3. 여기까지 왔는데 정답을 찾지 못했다면 접두어가 없다는 것이다.
        boolean answer = true;
        return answer;
    }
}
