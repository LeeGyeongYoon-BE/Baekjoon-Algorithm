import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    static int N, M, K;
    static int treeHeight, treeSize, leftNodeStartIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수의 개수
        M = Integer.parseInt(st.nextToken()); // 변경 횟수
        K = Integer.parseInt(st.nextToken()); // 구간합 횟수

        // 트리 높이 구하기
        int length = N;
        treeHeight = 0;
        while (length != 0) {
            length /= 2;
            treeHeight++;
        } // while

        // 트리 크기와 시작 인덱스
        treeSize = (int) Math.pow(2, treeHeight + 1);
        leftNodeStartIndex = treeSize / 2 - 1;

        tree = new long[treeSize + 1];

        // 입력값 넣기
        for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        } // for

        // 세그먼트 트리 구성
        setTree(treeSize - 1);

        // 쿼리 처리
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());

            if (a == 1) { // 값 변경
                changeVal(leftNodeStartIndex + s, e);
            } else if (a == 2) { // 구간 합
                int start = leftNodeStartIndex + s;
                int end = (int) (leftNodeStartIndex + e);
                sb.append(getSum(start, end)).append("\n");
            } // if ~ else if
        } // for

        System.out.print(sb);
    } // main

    // 세그먼트 트리 구간 합
    static long getSum(int s, int e) {
        long partSum = 0;

        while (s <= e) {
            if (s % 2 == 1) { // 오른쪽 자식일 경우
                partSum += tree[s];
                s++;
            } // if
            if (e % 2 == 0) { // 왼쪽 자식일 경우
                partSum += tree[e];
                e--;
            } // if
            s /= 2;
            e /= 2;
        } // while
        return partSum;
    } // getSum

    // 값 변경
    static void changeVal(int index, long val) {
        long diff = val - tree[index];
        while (index > 0) {
            tree[index] += diff;
            index /= 2;
        } // while
    } // changeVal

    // 세그먼트 트리 초기화
    static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] += tree[i];
            i--;
        } // while
    } // setTree
} // class
