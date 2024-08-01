package Algorithm4;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Week4_Day4 {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static final int MAX = 987654321;
    private static int N;
    private static char[] street;
    private static int[] dp;
    private static void input() throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        street = new char[N];
        street = bufferedReader.readLine().toCharArray();
        dp = new int[N];
        Arrays.fill(dp, MAX);
    }
    
    

    private static void solve() throws IOException {
    	Map<Character, Character> h = new HashMap<>();
    	
        h.put('B', 'O');
        h.put('O', 'J');
        h.put('J', 'B');
        
        dp[0] = 0;
        for(int i = 0; i < N-1; i++) {
            int now = i;
            char nowBlock = street[now];
            for(int j = i +1; j < N; j++) {
                 int next = j;
                 char nextBlock = street[next];
                 if(h.get(nowBlock) == nextBlock) {
                        dp[next] = Math.min(dp[next], dp[now] + (next-now) * (next-now));
                    }
               }
            }
        	if(dp[N-1] == MAX) {
        		System.out.println("-1\n");
        	} else {
        		System.out.println(dp[N-1]);
        	}
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
