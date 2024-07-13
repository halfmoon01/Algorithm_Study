package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Day6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String line= br.readLine();
			Stack<Character> s = new Stack<>();
			for(int j=0; j<line.length(); j++) {
				char c = line.charAt(j);
				if(c == ' ') {
					while(!s.isEmpty()) {
						sb.append(s.pop());
					}
					sb.append(c);
				}else {
					s.push(c);
				}
			}
			while(!s.isEmpty()) {
				sb.append(s.pop());
			}
			System.out.println(sb.toString());
		}
		br.close();
	}
}
