package pgms;

public class SkilChk_Lv1_01 {
	public static void main(String[] args) {
		int price = 3;
		int money = 20;
		int count=4;
		
		SkilChk_Lv1_01 sol = new SkilChk_Lv1_01();
		sol.solution(price, money, count);
	}
	public long solution(int price, int money, int count) {
        long chkMoney = money;
        
		for(int i=1; i<count+1; i++) {
			chkMoney -= i*price;
		}
		
		if(chkMoney<0) {
			return -chkMoney;
		}else {
			return 0;
		}
    }
}
