package Algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class Week2_Day6 {
    public static HashSet<String> visit;
    public static HashSet<String> okay;
    public static int N;
    public static int M;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] location = br.readLine().split(" ");
        visit = new HashSet<>();
        okay = new HashSet<>();
        N = Integer.parseInt(location[0]);
        M = Integer.parseInt(location[1]);

        for (int i = 0; i < N; i++) {  
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                String info = i + "-" + j;
                int go = line.charAt(j) - '0';
                if (go == 1) {
                    okay.add(info);
                }
            }
        }

        int result = bfs(0, 0);
        System.out.println(result);
    }

    public static int bfs(int startX, int startY) {

        Queue<int[]> qu = new ArrayDeque<>();
        qu.offer(new int[]{startX, startY, 1});
        visit.add(startX + "-" + startY);

        while (!qu.isEmpty()) {
            int[] current = qu.poll();
            int x = current[0];
            int y = current[1];
            int num = current[2];

            if (x == N - 1 && y == M - 1) {
                return num;
            }

            for (int k = 0; k < 4; k++) {
                int new_x = x + dx[k];
                int new_y = y + dy[k];
                String new_info = new_x + "-" + new_y;

                if (0 <= new_x && new_x < N && 0 <= new_y && new_y < M) {
                    if (!visit.contains(new_info) && okay.contains(new_info)) {
                        qu.add(new int[]{new_x, new_y, num + 1});
                        visit.add(new_info);
                    }
                }
            }
        }
        return -1;
    }
}

