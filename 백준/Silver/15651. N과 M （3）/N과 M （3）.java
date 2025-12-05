import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N];

        permutation(0);

        System.out.println(sb);
        br.close();
    } // main

    private static void permutation(int idx){

        if (idx >= M) {
            for (int i = 0; i < M; i++) {
                sb.append(list[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {

            list[idx] = i;
            permutation( idx + 1 );

        } // for

    } // permutation
} // class
