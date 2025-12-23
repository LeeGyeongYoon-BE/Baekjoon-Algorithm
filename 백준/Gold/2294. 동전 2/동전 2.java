import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        } // for

        int[] dp = new int [ K + 1 ]; // 0번지는 버림 // 15를 만드는 과정을 담는 배열
        for (int i = 1; i <= K; i++) {
            dp[i] = K + 1; // 각 칸을 16으로 초기화 -> 15를 만드는 과정을 담는다
        } // for

        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= K; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            } // for - j - dp
        } // for - i - coins

        System.out.println( dp[K] == K + 1 ? -1 : dp[K] );
        br.close();
    } // main
} // class
