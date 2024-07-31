package Algorithm4;

import java.util.Scanner;

public class Week4_Day3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력값 받기
        int K = sc.nextInt();
        int M = sc.nextInt();

        // 라인의 길이 배열 생성 및 초기화
        long[] lines = new long[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            lines[i] = sc.nextLong();
            if (lines[i] > max) {
                max = lines[i];
            }
        }

        // 이분 탐색을 위한 변수 초기화
        long left = 1;
        long right = max;
        long result = 0;

        // 이분 탐색 실행
        while (left <= right) {
            long sum = 0;
            long mid = (left + right) / 2;

            // 라인 나누기 계산
            for (int j = 0; j < K; j++) {
                sum += (lines[j] / mid);
            }

            // 충분한 조각 수가 나오지 않을 때
            if (sum < M) {
                right = mid - 1;
            } else { // 충분한 조각 수가 나올 때
                result = mid; // 가능한 최대 길이를 저장
                left = mid + 1;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}
