package Algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Week2_Day1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, HashSet<Integer>> Graph = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		String[] info = br.readLine().split(" ");
		int N = Integer.parseInt(info[0]);
		int M = Integer.parseInt(info[1]);
		int V = Integer.parseInt(info[2]);
		for(int j=1; j<=N; j++) {
			Graph.put(j, new HashSet<>());
		} // 미리 셋팅 
		
		for(int i=0; i<M ; i++) {
			String[] line = br.readLine().split(" ");
			int N1 = Integer.parseInt(line[0]);
			int N2 = Integer.parseInt(line[1]);
			Graph.get(N1).add(N2);
			Graph.get(N2).add(N1);
		}
		///////// DFS
		Set<Integer> visit = new HashSet<>();
		Stack<Integer> st = new Stack<>();
		st.add(V);
		while(!st.isEmpty()) {
			int element = st.pop();
			if(!visit.contains(element)) {
				sb.append(element + " ");
				visit.add(element);
				Object[] graph_arr = Graph.get(element).stream().sorted(
						(o1, o2) ->
							Integer.compare(o2, o1)).toArray();
				
				for(Object el : graph_arr) {
					if(!visit.contains(el)) {
						st.push((Integer) el);
					}
				}	
			}	
		}
		System.out.println(sb.toString());
		
		///////// BFS
		sb = new StringBuilder();
		visit = new HashSet<>();
		Queue<Integer> qu = new ArrayDeque<>();
		qu.add(V);
		while(!qu.isEmpty()) {
			int element = qu.poll();
			if(!visit.contains(element)) {
				sb.append(element + " ");
				visit.add(element);
				for(int el : Graph.get(element)) {
					if(!visit.contains(el)) {
						qu.offer(el);
					}
				}
				
			}
		}
		System.out.println(sb.toString());
		
	}
}
