import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] arr;
    static List<Long> leftSum = new ArrayList<>();
    static List<Long> rightSum = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        // 왼쪽 / 오른쪽 절반으로 나누기
        dfs(0, N / 2, 0, leftSum);
        dfs(N / 2, N, 0, rightSum);

        Collections.sort(leftSum);
        Collections.sort(rightSum);

        long count = 0;
        int l = 0, r = rightSum.size() - 1;

        // 투 포인터 탐색
        while (l < leftSum.size() && r >= 0) {
            long sum = leftSum.get(l) + rightSum.get(r);

            if (sum == S) {
                long leftVal = leftSum.get(l);
                long rightVal = rightSum.get(r);
                long leftCount = 0, rightCount = 0;

                while (l < leftSum.size() && leftSum.get(l) == leftVal) {
                    leftCount++; l++;
                } // while
                while (r >= 0 && rightSum.get(r) == rightVal) {
                    rightCount++; r--;
                } // while
                count += leftCount * rightCount;
            } else if (sum < S) {
                l++;
            } else {
                r--;
            } // if ~ else
        } // while

        // S=0일 때는 공집합 제외
        if (S == 0) count--;

        System.out.println(count);
        br.close();
    } // main

    // 부분합 생성
    static void dfs(int start, int end, long sum, List<Long> list) {
        if (start == end) {
            list.add(sum);
            return;
        } // if
        dfs(start + 1, end, sum, list);           // 해당 원소를 선택 안 함
        dfs(start + 1, end, sum + arr[start], list); // 해당 원소 선택
    } // dfs
} // class
