import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine()); // 층
            int N = Integer.parseInt(br.readLine()); // 호
            int[][] D = new int[15][15];
            for (int i = 1; i <= N; i++) {
                D[0][i] = i;
                D[i][1] = 1;
            } // for
            for (int i = 1; i <= K; i++) {
                for (int j = 1; j <= N; j++) {
                    D[i][j] = D[i][j - 1] + D[i - 1][j];
                } // for - j
            } // for - i
            System.out.println(D[K][N]);
        } // while

        br.close();
    } // main
} // class
