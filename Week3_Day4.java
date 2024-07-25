package Algorithm3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Week3_Day4{
	public static int[] intNumbers;
	public static int N;
	public static int S;
	public static int count;
	public static Set<Integer> visit = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		N = Integer.parseInt(info[0]);
		S = Integer.parseInt(info[1]);
		String [] numbers = br.readLine().split(" ");
	    intNumbers = new int[N];
	    for (int i = 0; i < N; i++) {
	    	intNumbers[i] = Integer.parseInt(numbers[i]);
	    }
	    
		for(int i=1; i<=N; i++) {
			ArrayList<Integer> al = new ArrayList<>();
			dfs(0,i, al); // 원소의 개수가 i개인 부분집합 구하기 
		}
		System.out.println(count);
	}

	private static void dfs(int step, int num, ArrayList<Integer> al) {
		if(step == num) {
			int result = 0;
			for(int el : al) {
				result += el;
			}
			if(result == S) {
				count++;
			}
			return;
		}
		for(int i=step; i<N; i++) {
			al.add(intNumbers[i]);
			dfs(i+1, num, al);
			al.remove(al.size()-1);
		}
	}
}