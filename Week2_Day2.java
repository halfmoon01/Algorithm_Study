package Algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

//DFS 를 활용?

public class Week2_Day2 {
	
	public static int dx[] = {0,0,1,-1};
	public static int dy[] = {1,-1,0,0};
	public static int[][] map;
	public static int N;
	public static boolean[][] visited;
	public static HashMap<Integer, HashSet<int[]>> Graph;
	public static void main(String[] args) throws IOException {
		Graph = new HashMap<>();
		StringBuilder sb = new StringBuilder();
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String line = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = line.charAt(j)-'0';
			}
		}
		int danji = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				// 만약 집이 있고, 방문학적 없다면, 단지 ++; 시작지점 설정 
				if(map[i][j] == 1 && visited[i][j] == false) {
					danji++;
					Graph.put(danji, new HashSet<int[]>());
					// danji 단지 해당하는 좌표를 저장할 HashSet 만들기 
					dfs(i,j,danji);
				}
			}
		}
		int M = Graph.size();
		System.out.println(M);
		int[] result = new int[M];
		for(int i=1; i<=M; i++) {
			result[i] =  Graph.get(i).size();
		}
		// 사이즈 입력 
		
		Arrays.sort(result); // 정렬 
		
		//출력 
		
		for(int i=0; i<M; i++) {
			System.out.println(result[i]);
		}
	}
	
	 private static void dfs(int x, int y, int count) {
		 	//System.out.println("x" + x + "y" + y);
	    	visited[x][y] = true;
	    	Graph.get(count).add(new int[] {x,y});
	    	for(int i=0; i<4; i++) {
	    		int new_x = x + dx[i];
	    		int new_y = y + dy[i];
	    		//System.out.println("new_X" + new_x + "new_Y" + new_y);
	    		if((0 <= new_x && new_x < N) && (0 <= new_y &&  new_y< N)) {
	    			if(map[new_x][new_y] == 1 && visited[new_x][new_y] == false) {
	    				dfs(new_x, new_y, count);
	    			}
	    		}
	    	}
	    	
	    }
}
