// 연속된 구간의 합을 빠르게 구하기 위한 알고리즘
// 배열의 합을 미리 계산해두고, 필요한 구간 합을 O(1)에 구할 수 있음
// 많이 쓰이는 구간 합 문제 최적화 기법

// idea
// 1. 배열 arr의 누적합 배열 sum을 만든다
sum[i] = arr[0] + arr[1] + ... + arr[i]

// 2. 구간 [l, r]의 합은
arr[l] + arr[l + 1] + ... + arr[r] = sum[r] - sum[l - 1] (l > 0)
  
// 1차원 누적합
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sum = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = arr[i] + (i > 0 ? sum[i - 1] : 0); // 누적합 계산
        } // for

        // 예시: 구간 [L, R] 합 구하기
        int L = 1, R = 3; // 0-indexed
        int intervalSum = sum[R] - (L > 0 ? sum[L - 1] : 0);
        System.out.println(intervalSum);

        br.close();
    } // main
} // class
