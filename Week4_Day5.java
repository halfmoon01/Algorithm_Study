package Algorithm4;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Week4_Day5 {

    public static boolean check(int number, int M) {
        return number >= 0 && number <= M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        String[] initialInput = br.readLine().split(" ");
        int N = Integer.parseInt(initialInput[0]);
        int S = Integer.parseInt(initialInput[1]);
        int M = Integer.parseInt(initialInput[2]);

        String[] volumeChanges = br.readLine().split(" ");
        int[][] dp = new int[N][M + 1];
        // Initialize dp array to zero
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        // Initial state
        int firstChange = Integer.parseInt(volumeChanges[0]);
        int op1 = S + firstChange;
        int op2 = S - firstChange;

        if (check(op1, M)) {
            dp[0][op1] = 1;
        }
        if (check(op2, M)) {
            dp[0][op2] = 1;
        }

        // Update dp array for each volume change
        for (int i = 1; i < N; i++) {
            int volumeChange = Integer.parseInt(volumeChanges[i]);
            boolean updated = false;
            for (int j = 0; j <= M; j++) {
                if (dp[i-1][j] == 1) {
                    op1 = j + volumeChange;
                    op2 = j - volumeChange;
                    if (check(op1, M)) {
                        dp[i][op1] = 1;
                        updated = true;
                    }
                    if (check(op2, M)) {
                        dp[i][op2] = 1;
                        updated = true;
                    }
                }
            }
            if (!updated) {
                System.out.println("-1");
                return;
            }
        }

        // Find the maximum volume that can be achieved
        for (int i = M; i >= 0; i--) {
            if (dp[N-1][i] == 1) {
                System.out.println(i);
                break;
            }
        }
    }
}

