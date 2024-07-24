package Algorithm3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class Week3_Day3 {
	public static int N, M;
	public static int[][] gameMatch = 
			{{1,2}, {1, 3}, {1,4}, {1,5}, {1,6}, 
			{2,3}, {2, 4}, {2,5}, {2,6}, 
			{3,4}, {3,5}, {3,6}, 
			{4,5}, {4, 6}, 
			{5,6}};
	public static int answer = 0;
	public static boolean success = false;
	public static HashMap<Integer, Game> hm = new HashMap<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	for(int t=0; t<4; t++) {
    		String line = br.readLine();
    		success = false;
    		int count = 1;
    		int i = 0;
    		while(count <= 6) {
    			String[]info = line.substring(i,i+5).split(" ");
    			Game g = new Game(Integer.parseInt(info[0]), Integer.parseInt(info[1]), Integer.parseInt(info[2]));
    			hm.put(count, g);
    			i += 6;
    			count++;
    		}
    		
        	simulate(0);
        	if(success) {
        		System.out.println(1);
        	}else {
        		System.out.println(0);
        	}
    	}
    	
    	//경기 
    	
    }
	public static void simulate(int level) {
		if(success == true) {
			return;
		}
		if(level == 15) { //15번 경기가 끝나면 총 30개의 승/무/패가 기록됩니다.
			success = true;
			return;
		}
		
		int team1 = gameMatch[level][0]; // 0
		int team2 = gameMatch[level][1]; // 1
		
		//승 : 패 조사
		if( hm.get(team1).win > 0 && hm.get(team2).lose > 0) {
			hm.get(team1).win--;
			hm.get(team2).lose--;
			simulate(level+1);
			hm.get(team1).win++;
			hm.get(team2).lose++;
		}
		
		// 무 : 무 조사
		if( hm.get(team1).draw > 0 && hm.get(team2).draw > 0) {
			hm.get(team1).draw--;
			hm.get(team2).draw--;
			simulate(level + 1);
			hm.get(team1).draw++;
			hm.get(team2).draw++;
		}
		
		//패 : 승
		if( hm.get(team1).lose > 0 && hm.get(team2).win > 0) {
			hm.get(team1).lose--;
			hm.get(team2).win--;
			simulate(level + 1);
			hm.get(team1).lose++;
			hm.get(team2).win++;
		}
		
	}
 
}


class Game{
	int win;
	int draw;
	int lose;
	public Game(int win, int draw, int lose) {
		super();
		this.win = win;
		this.draw = draw;
		this.lose = lose;
	}
}


