import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // H = 가장 작은 2의 제곱수 (leaf 시작 인덱스)
        int H = 1;
        while (H < N) H <<= 1;

        // 트리 크기: 2*H (1번부터 사용)
        tree = new long[H * 2];

        // 중요: 최솟값 쿼리이므로 초기값을 아주 큰 값으로 채움
        Arrays.fill(tree, Long.MAX_VALUE);

        // 리프에 입력값 채우기 (입력은 1번부터 N번까지 한 줄씩 주어짐)
        for (int i = 0; i < N; i++) {
            long val = Long.parseLong(br.readLine().trim());
            tree[H + i] = val; // element i+1 -> index H + i
        } // for

        // 부모 노드 초기화: 각 부모 = 자식 둘 중 작은 값
        for (int i = H - 1; i >= 1; i--) {
            tree[i] = Math.min(tree[i << 1], tree[i << 1 | 1]);
        } // for

        StringBuilder sb = new StringBuilder();
        // 쿼리 처리
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            // 1-based 입력을 리프 인덱스로 변환
            int left = H + (s - 1);
            int right = H + (e - 1);
            sb.append(getMin(left, right)).append('\n');
        } // for
        System.out.print(sb);
    } // main

    // 세그먼트 트리(완전이진트리 배열)에서 [s..e] (배열 인덱스) 범위의 최소값
    private static long getMin(int s, int e) {
        long ans = Long.MAX_VALUE;
        while (s <= e) {
            if ((s & 1) == 1) {        // s가 오른쪽 자식이면 포함
                ans = Math.min(ans, tree[s]);
                s++;
            } // if
            if ((e & 1) == 0) {        // e가 왼쪽 자식이면 포함
                ans = Math.min(ans, tree[e]);
                e--;
            } // if
            s >>= 1;
            e >>= 1;
        } // while
        return ans;
    } // getMin
} // class
