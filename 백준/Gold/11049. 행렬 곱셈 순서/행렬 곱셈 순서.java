import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Matrix[] M;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = new Matrix[N + 1];
        dp = new int[N + 1][N + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = -1;
            } // for - j
        } // for - i
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            M[i] = new Matrix(y, x);
        } // for

        System.out.println(execute(1, N));

        br.close();
    } // main
    static int execute(int s, int e) {
        int result = Integer.MAX_VALUE;
        if (dp[s][e] != -1) { // 이미 계산되어 있으면 바로 리턴
            return dp[s][e];
        } // if
        if (s == e) {
            return 0;
        } // if
        if (s + 1 == e) {
            return M[s].y * M[s].x * M[e].x;
        } // if
        for (int i = s; i < e; i++){
            int a = M[s].y * M[i].x * M[e].x;
            result = Math.min(result, execute(s, i) + execute(i + 1, e) + a);
        } // for
        return dp[s][e] = result;
    } // execute

    static class Matrix {
        private int y, x;
        Matrix(int y, int x) {
            this.y = y;
            this.x = x;
        } // Matrix
    } // class - Matrix
} // class
