package Algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Week2_Day3 {
	
	public static HashMap<Integer, HashSet<Integer>> graph;
	public static Set<Integer> visit;
	
	public static void main(String[] args) throws IOException {
		graph = new HashMap<>();
		visit = new HashSet<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		int N = Integer.parseInt(info[0]);
		int M = Integer.parseInt(info[1]);
		for(int j=1; j<=N; j++) {
			graph.put(j, new HashSet<>());
		}
		
		for(int i=0; i<M; i++) {
			String[] line = br.readLine().split(" ");
			int N1 = Integer.parseInt(line[0]);
			int N2 = Integer.parseInt(line[1]);
			graph.get(N1).add(N2);
			graph.get(N2).add(N1);
		}
		int count = 0;
		for(int j=1; j<=N; j++) {
			if(!visit.contains(j)) {
				count++;
				dfs(j);
			}
		}
		System.out.println(count);
	}
	
	public static void dfs(int now) {
    	visit.add(now);
    	for(int el : graph.get(now)) {
    		if(!visit.contains(el)) {
    			dfs(el);
    		}
    	}
    }
}
