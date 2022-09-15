package kakao_blind_2021;

public class Lv3_광고삽입 {
	public static void main(String[] args) {
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
		
		Lv3_광고삽입 sol = new Lv3_광고삽입();
		sol.solution(play_time, adv_time, logs);
	}
	
	 public String solution(String play_time, String adv_time, String[] logs) {
		 String answer="00:00:00";
		 
		 int playTime = timeToSec(play_time);
		 int advTime = timeToSec(adv_time);
		 
		 int[] acc = new int[playTime+1];
		 for(String log : logs) {
			 String[] str = log.split("-");
			 int st = timeToSec(str[0]);
			 int en = timeToSec(str[1]);
			 
			 for(int i=st; i<en; i++) {
				 acc[i]++;
			 }
		 }
		 
		 long max=0;
		 for(int i=0; i<=advTime; i++) {
			 max += acc[i];
		 }
		 
		 long cur = max;
		 for(int i=0, j=advTime+1; j<playTime+1; i++, j++) {
			 cur = cur-acc[i]+acc[j];
			 
			 if(cur>max) {
				 max = cur;
				 answer = secToTime(i+1);
			 }
		 }
		 
		 
		 System.out.println(answer);
		 return answer;
	 }

	private String secToTime(int num) {
		String h = (num/60/60)>9? Integer.toString(num/60/60):"0"+Integer.toString(num/60/60);
		num %= 3600;		
		String m = (num/60)>9? Integer.toString(num/60):"0"+Integer.toString(num/60);
		num %= 60;
		String s = num>9?Integer.toString(num):"0"+Integer.toString(num);
		
		return h+":"+m+":"+s;
	}

	private int timeToSec(String time) {
		String[] str = time.split(":");
		int h = Integer.parseInt(str[0])*60*60;
		int m = Integer.parseInt(str[1])*60;
		int s = Integer.parseInt(str[2]);
		return h+m+s;
	}
}
