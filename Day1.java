package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.IOException;

public class Day1 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] Stack = new int[N];
        int top = -1;
        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            String[] parts = cmd.split(" ");
            switch (parts[0]) {
                case "push":
                    int M = Integer.parseInt(parts[1]);
                    top++;
                    Stack[top] = M;
                    break;
                case "pop":
                    if (top == -1) {
                        System.out.println(-1);
                    } else {
                        System.out.println(Stack[top--]);
                    }
                    break;
                case "size":
                    System.out.println(top+1);
                    break;
                case "empty":
                	if(top == -1) {
    					System.out.println(1);
    				}else {
    					System.out.println(0);
    				}
                    break;
                case "top":
                    if (top == -1) {
                        System.out.println(-1);
                    } else {
                        System.out.println(Stack[top]);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}