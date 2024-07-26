package Algorithm3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Week3_Day5 {
	public static Set<Character> moeum = new HashSet<>();
	public static ArrayList<Character> al = new ArrayList<>();
	public static char[] alphabet;
	public static int L;
	public static int C;
	public static void main(String[] args) throws IOException {
		moeum.add('a');
		moeum.add('e');
		moeum.add('i');
		moeum.add('o');
		moeum.add('u');
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String info[] = br.readLine().split(" ");
		L = Integer.parseInt(info[0]);
		C = Integer.parseInt(info[1]);
		alphabet = new char[C];
		String[]line =  br.readLine().split(" ");
		for(int i=0; i<C; i++) {
			alphabet[i] = line[i].charAt(0);
		}
		Arrays.sort(alphabet);
		dfs(0);
	}

	private static boolean isMoeum(char c) {
		if(moeum.contains(c)) {
			return true;
		}
		return false;
	}

	private static void dfs(int step) {
		if(al.size() == L) {
			int count = 0;
			String result = "";
			for(char c : al) {
				if(isMoeum(c)) {
					count++;
				}
				result += c;
			}
			// 모음 개수가 1이상이고 나머지(자음) 개수가 2 이상 
			if(count >= 1 && (L-count) >= 2) {
				System.out.println(result);
			}
			return;
		}
		for(int i=step; i<C; i++) {
			char K = alphabet[i];
			al.add(K);
			dfs(i+1);
			al.remove(al.size()-1);
		}
	}
}
