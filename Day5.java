package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.ArrayDeque;

public class Day5{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N ;i++) {
			int count = 1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int wanted = Integer.parseInt(st.nextToken());
			Queue<int[]> qu = new ArrayDeque<>();
			
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M ; j++) {
				qu.add(new int[] {j, Integer.parseInt(st.nextToken())});
			}
			
			while(true) {
				boolean isMAX = true;
				int max = qu.peek()[1];
				for(int[] el: qu) {
					if(el[1] > max) {
						int[] removed = qu.poll();
						qu.add(removed);
						isMAX = false;
						break;
					}else {
						continue;
					}
				}
				if(isMAX) {
					int[] removed = qu.poll();
					if(removed[0] != wanted) {
						count++;
					}else {
						sb.append(count + "\n");
						break;
					}
				}
			}	
		}
		System.out.println(sb.toString());
	}
	
}
