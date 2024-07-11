package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Day4{
	public static void main(String[] strings) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			Stack<String> ss = new Stack<>();
			boolean VPS = true;
			StringTokenizer st = new StringTokenizer(br.readLine(), "()", true);
			while(st.hasMoreTokens()) {
				String element = st.nextToken();
				if(element.equals("(")) {
					ss.push(element);
				}else {
					if(ss.isEmpty()) {
						VPS = false;
						break;
					}
					ss.pop();
				}
			}
			if(ss.isEmpty() && VPS == true) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
}