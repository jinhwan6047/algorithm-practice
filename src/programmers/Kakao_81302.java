package programmers;

import java.util.Arrays;

public class Kakao_81302 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answer = new int[5];
        String[][] places = {{"POOOP", 
        					  "OXXOX", 
        					  "OPXPX", 
        					  "OOXOX", 
        					  "POXXP"},
        		
                            {"POOPX", 
        					 "OXPXP", 
        					 "PXXXO", 
        					 "OXXXO", 
        					 "OOOPP"},
                            
                            {"PXOPX", 
        					 "OXOXP", 
        					 "OXPOX", 
        					 "OXXOP", 
        					 "PXPOX"},
                            
                            {"OOOXX", 
        					 "XOOOX", 
        					 "OOOXX", 
        					 "OXOOX", 
        					 "OOOOO"},
                            
                            {"PXPXP", 
        					 "XPXPX", 
        					 "PXPXP", 
        					 "XPXPX", 
        					 "PXPXP"}};  
        int num = 0;
        Arrays.fill(answer, 1);
        String[][] arr = new String[5][5];
        String[][] result = new String[7][7];      
        
        while(num<5) {
        	
        	for(int i=0; i<7; i++) {
        		Arrays.fill(result[i], "X");
        	}
        	for(int i=0; i<5; i++) {
        		arr[i] = places[num][i].split("");
        	}
        	
        	for(int i=1; i<6; i++) {
        		for(int j=1; j<6; j++) {
        			result[i][j] = arr[i-1][j-1];
        		}
        	}        
        	
        	loop:
        	for(int i=1; i<6; i++) {
        		for(int j=1; j<6; j++) {
        			if(result[i][j].equals("P")) {
        				if(result[i][j+1].equals("P")) {
        					answer[num] = 0;
        					break loop;
        				}else if(result[i][j+1].equals("O")) {
        					if(result[i][j+2].equals("P") || result[i+1][j+1].equals("P")) {
        						answer[num] = 0;
        						break loop;
        					}
        				}
        				if(result[i+1][j].equals("P")) {
        					answer[num] = 0;
        					break loop;
        				}else if(result[i+1][j].equals("O")) {
        					if(result[i+1][j+1].equals("P") || result[i+1][j-1].equals("P") || result[i+2][j].equals("P")) {
        						answer[num] = 0;
        						break loop;
        					}
        				}
        				if(result[i][j-1].equals("P")) {
        					answer[num] = 0;
        					break loop;
        				}else if(result[i][j-1].equals("O")) {
        					if(result[i+1][j-1].equals("P")) {
        						answer[num] = 0;
        						break loop;
        					}
        				}
        			}
        		}
        	}
        	
        	num ++;
        }
     for(int i=0; i<5; i++) {
    	 System.out.print(answer[i]+", ");
     }
	}

}
