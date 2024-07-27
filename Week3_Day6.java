package Algorithm3;

import java.util.Scanner;

public class Week3_Day6 {
    public static int N;
    public static boolean First = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();
        dfs(0, "");
    }

    private static void dfs(int step, String str) {
    	if(First == true) {
    		return;
    	}
        if (step == N && isGood(str) && First == false) {
            System.out.println(str);
            First = true;
            return;
        }
        
        for (int i = 1; i <= 3; i++) {
            String newStr = str + i;
            // 미리 가지치기! (Pruning)
            if (isGood(newStr)) {
                dfs(step + 1, newStr);
            }
        }
    }

    private static boolean isGood(String str) {
        int len = str.length();
        for (int i = 1; i <= len / 2; i++) { // substring 이용 
            for (int j = 0; j + 2 * i <= len; j++) {
                String s1 = str.substring(j, j + i);
                String s2 = str.substring(j + i, j + 2 * i);
                if (s1.equals(s2)) {
                    return false;  // Return false for a bad sequence
                }
            }
        }
        return true; 
    }
}

