package Algorithm3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Week3_Day2 {
	static int N,M;
	static Set<String> set = new LinkedHashSet<>();
	static Set<Integer> visit = new HashSet<>();	
	static ArrayList<Integer> al = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line =  br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
	
		dfs(0);
		System.out.println(sb.toString());
	}
	
	private static void dfs(int start) {
		if(start == M) {
			for(int el : al) {
				sb.append(el).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=1; i<=N; i++) {
				al.add(i);
				dfs(start+1);
				al.remove(al.size()-1);
		}
	}
}

