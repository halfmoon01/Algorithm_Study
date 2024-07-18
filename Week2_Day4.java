package Algorithm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Week2_Day4 {
    public static Set<Baechoo> visit;
    public static Set<Baechoo> location;
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    public static int M;
    public static int N;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int j = 0; j < T; j++) {
            String[] info = br.readLine().split(" ");
            M = Integer.parseInt(info[0]);
            N = Integer.parseInt(info[1]);
            int K = Integer.parseInt(info[2]);

            location = new HashSet<>();
            visit = new HashSet<>();
            for (int i = 0; i < K; i++) {
                String[] each = br.readLine().split(" ");
                int each_x = Integer.parseInt(each[0]);
                int each_y = Integer.parseInt(each[1]);
                Baechoo new_b = new Baechoo(each_x, each_y);
                location.add(new_b);
            }

            int count = 0;
            for (int i = 0; i < M; i++) {
                for (int k = 0; k < N; k++) {
                    Baechoo new_bb = new Baechoo(i, k);
                    if (location.contains(new_bb) && !visit.contains(new_bb)) {
                        dfs(new_bb);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(Baechoo bc) {
        visit.add(bc); 
        for (int j = 0; j < 4; j++) {
		        int new_x = bc.x + dx[j];
		        int new_y = bc.y + dy[j];
            if (0 <= new_x && new_x < M && 0 <= new_y && new_y < N) {  // 경계 검사 수정
                  Baechoo new_b = new Baechoo(new_x, new_y);
                  if (location.contains(new_b) && !visit.contains(new_b)) {
	                       dfs(new_b);
                    }
                }
            }
        }
    }

class Baechoo {
    int x;
    int y;

    public Baechoo(int x, int y) {
        this.x = x;
        this.y = y;
    }
    ///////////////?????????? 이렇게 해야 같은 좌표의 객체를 동일하게처리??
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baechoo baechoo = (Baechoo) o;
        return x == baechoo.x && y == baechoo.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}

