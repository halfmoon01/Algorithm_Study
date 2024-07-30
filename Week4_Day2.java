package Algorithm4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

/// 딱 정확히 설정시킬수 있는 높이의 최댓값을 구하시오.
public class Week4_Day2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		int N = Integer.parseInt(info[0]);
		int M = Integer.parseInt(info[1]);
		int[] h = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		int left = 0;
		int right = Arrays.stream(h).max().getAsInt();
		while(left <= right) {
			long total = 0;
			int mid = (left + right)/2;
			for(int j=0; j<N; j++) {
				if(mid < h[j]) {
					total+= (h[j]-mid);
				}
			}
			if (total < M) {
				right = mid-1;
			}else {
				left =  mid +1;
			}
		}
		System.out.println(right);
	}
}
