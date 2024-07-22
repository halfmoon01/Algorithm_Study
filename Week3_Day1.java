package Algorithm3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Week3_Day1 {
    public static int N, M;
    public static int[] answerArr;
    public static StringBuilder sb = new StringBuilder();
    public static LinkedHashSet<String> hashset = new LinkedHashSet<String>(); 
    // hashset은 전체 결과를 담는 Set 
    public static HashSet<Integer> visit = new HashSet<>();
    
    public static String[] numbers;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        N = Integer.parseInt(num[0]);
        M = Integer.parseInt(num[1]);
        
        numbers = br.readLine().split(" ");
        Arrays.sort(numbers);
        
        dfs(0, "");
        
        for(String i : hashset) {
			System.out.println(i);
		}
    }
   
    public static void dfs(int step, String str) {
    	if(step == M) {
    		hashset.add(str);
    		return ;
    	}
    	for(int i=0; i<N; i++) {
    		if(!visit.contains(i)) {
    			visit.add(i);
    			dfs(step+1,str+numbers[i]+" ");
    			visit.remove(i);
    		}
    	}
    }    
}


