import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[][] D = new long [101][11];
    static final long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 9; i++) {
            D[1][i] = 1;
        } // for

        for (int i = 2; i <= N; i++) {
            D[i][0] = D[i - 1][1];
            D[i][9] = D[i - 1][8];

            for (int j = 1; j <= 8; j++) {
                D[i][j] = (D[i - 1][j - 1] + D[i - 1][j + 1]) % MOD;
            } // for - j
        } // for - i
        
        long sum = 0;
        for (int k = 0; k <= 9; k++) {
            sum = (sum + D[N][k]) % MOD;
        } // for - k
        System.out.println(sum);
        br.close();
    } // main
} // class
