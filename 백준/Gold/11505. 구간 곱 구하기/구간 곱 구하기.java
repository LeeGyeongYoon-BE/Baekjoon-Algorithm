import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    static int N, M, K;
    static int H; // 세그먼트 트리 리프 시작 인덱스
    static final long MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수의 개수
        M = Integer.parseInt(st.nextToken()); // 변경 횟수
        K = Integer.parseInt(st.nextToken()); // 곱 구하는 횟수

        // H = N 이상인 최소 2의 거듭제곱
        H = 1;
        while (H < N) H *= 2;

        tree = new long[H * 2];
        Arrays.fill(tree, 1); // 곱셈 항등원 = 1

        // 리프에 입력값 저장
        for (int i = 0; i < N; i++) {
            tree[H + i] = Long.parseLong(br.readLine());
        } // for

        // 부모 노드 채우기
        for (int i = H - 1; i > 0; i--) {
            tree[i] = (tree[i * 2] * tree[i * 2 + 1]) % MOD;
        } // for

        StringBuilder sb = new StringBuilder();

        // 쿼리 처리
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) { // 값 변경
                update(H + b - 1, c);
            } else if (a == 2) { // 구간 곱
                sb.append(query(H + b - 1, H + (int)c - 1)).append("\n");
            } // if ~ else if
        } // for
        System.out.print(sb.toString());
    } // main

    // 값 변경 (단일 갱신)
    private static void update(int index, long val) {
        tree[index] = val % MOD;
        index /= 2;
        while (index > 0) {
            tree[index] = (tree[index * 2] * tree[index * 2 + 1]) % MOD;
            index /= 2;
        } // while
    } // update

    // 구간 곱 쿼리
    private static long query(int s, int e) {
        long result = 1;
        while (s <= e) {
            if (s % 2 == 1) result = (result * tree[s++]) % MOD;
            if (e % 2 == 0) result = (result * tree[e--]) % MOD;
            s /= 2;
            e /= 2;
        } // if
        return result;
    } // query
} // class
