package Algorithm2;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Week2_Day5 {
	
	public static Set<Integer> visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		visit = new HashSet<>();
		int result = bfs(A,B);
		System.out.println(result);
	}

	private static int bfs(int a, int b) {
		Queue<int[]> qu =new ArrayDeque<>();
		qu.offer(new int[] {a,0});
		visit.add(a);
		
		while(!qu.isEmpty()) {
			int[] curr = qu.poll();
			int point = curr[0];
			int count = curr[1];
			if(point == b) {
				return count;
			}
      int next = 0;
			int[] next_point = new int[] {point-1, point+1, point*2};
			 for(int i=0; i<3; i++) {
				next = next_point[i];
				if(next >= 0 && next <= 100000 && !visit.contains(next)) {
					qu.add(new int[] {next,count+1});
					visit.add(next);
				}
			}
		}
		return -1;
	}
}