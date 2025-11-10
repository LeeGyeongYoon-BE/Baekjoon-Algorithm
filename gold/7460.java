import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            dfs(2, N, 1, 1, "1"); // 1부터 시작
            System.out.println(sb);
        } // while

        br.close();
    } // main

    static void dfs(int num, int N, int sum, int prev, String expr) {
        if (num > N) { // 마지막 숫자까지 도달
            if (sum == 0) sb.append(expr).append("\n");
            return;
        } // if

        // 1) 공백: 이전 숫자와 이어붙이기
        int newPrev = prev > 0 ? prev * 10 + num : prev * 10 - num; // 부호 유지
        dfs(num + 1, N, sum - prev + newPrev, newPrev, expr + " " + num);

        // 2) + 연산
        dfs(num + 1, N, sum + num, num, expr + "+" + num);

        // 3) - 연산
        dfs(num + 1, N, sum - num, -num, expr + "-" + num);
    } // dfs
} // class
