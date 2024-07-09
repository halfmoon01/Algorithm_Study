package Algorithm;

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;
public class Day2 {
	public static void main(String[] args) {
		ArrayDeque<Integer> qu = new ArrayDeque<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			qu.addLast(i);
		}
		System.out.print("<");
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<K-1; j++) {
				int M = qu.removeFirst();
				qu.addLast(M);
			}
			int M = qu.removeFirst();
			System.out.print(M+", ");
		}
		System.out.println(qu.removeFirst()+ ">");
	}
}
